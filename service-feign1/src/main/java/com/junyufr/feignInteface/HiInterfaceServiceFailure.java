package com.junyufr.feignInteface;

import org.springframework.stereotype.Component;

@Component
public class HiInterfaceServiceFailure implements HiInterface {

    @Override
    public String sayHiFronClientOne(String param) {
        return "service-hi is not available !";
    }
}
