package com.junyufr.feignInteface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi",fallback = HiInterfaceServiceFailure.class)//调用的服务名以及服务异常的错误回调（熔断）
public interface HiInterface {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFronClientOne(@RequestParam("param") String param);
}
