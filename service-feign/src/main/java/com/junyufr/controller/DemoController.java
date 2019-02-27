package com.junyufr.controller;

import com.junyufr.feignInteface.HiInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    HiInterface hiInterface;

    @RequestMapping("/hi")
    public String hi() {
        return hiInterface.sayHiFronClientOne("params");
    }
    @RequestMapping(value = "/testTimeout",method = RequestMethod.GET)
    public String testTimeOut(Integer outTime) {
        return hiInterface.testTimeout(outTime);
    }
}
