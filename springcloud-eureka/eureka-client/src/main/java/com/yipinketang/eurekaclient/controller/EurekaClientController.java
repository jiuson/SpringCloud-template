package com.jiuson.eurekaclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaClientController {

    @GetMapping("/getServiceMethod")
    public String getServiceMethod(){
        return "this is eureka client";
    }
}
