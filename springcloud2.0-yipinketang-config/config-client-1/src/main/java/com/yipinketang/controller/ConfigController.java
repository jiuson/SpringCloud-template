package com.yipinketang.controller;

import com.yipinketang.generalResponse.GeneralResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

    @Value("${hello}")
    private String hello;

    @GetMapping("/getConfigProperties")
    public GeneralResponse getConfigProperties(){
        String result = "this properties from config-center of github:[hello:" + hello + "]";
        return new GeneralResponse(0, "OK", result);
    }

}
