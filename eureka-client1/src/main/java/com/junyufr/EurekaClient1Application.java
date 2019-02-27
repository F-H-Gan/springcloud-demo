package com.junyufr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EurekaClient1Application {
    @Value("${neo.hello}")//读取github仓库配置文件
    private String configParam;

    @Value("${server.port}")//读取本地配置文件接口（application.properties）
    private String readPort;


    public static void main(String[] args) {
        SpringApplication.run(EurekaClient1Application.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String hi(String param){
        return "Ip"+port+"--"+param;
    }
    /**
     * @author freeagain
     * @param
     * @return
     * @date 2019/2/25 18:03
     * @DESC 为测试断路器超时时间提供的接口
     */
    @RequestMapping("/testTimeout")
    public String testTimeout(Integer outTime){
        if (outTime!=null){
            try {
                Thread.sleep(outTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "Ip"+port+"--休眠时间："+outTime;
    }
    /**
     * @author freeagain
     * @param
     * @return
     * @date 2019/2/25 18:05
     * @DESC 读取配置文件接口(gitHub上的)
     */
    @RequestMapping("/getConfigParam")
    public String getConfigParam(String param){
        return configParam;
    }
    /**
     * @author freeagain
     * @param
     * @return
     * @date 2019/2/25 18:09
     * @DESC 读取本地配置文件接口（application.properties）
     */
    @RequestMapping("/getConfigParam1")
    public String getConfigParam1(String param){
        return readPort;
    }

}

