package com.yipinketang.provider.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class ProviderController {
    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String serverName;

    @PostMapping("/getProviderService")
    public String getProviderService(HttpServletRequest request){
        Map param = request.getParameterMap();
        try {
            Thread.currentThread().sleep(1500);//让服务延迟1.5秒再返回结果
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "这里是服务的提供方，服务名称为:[" + serverName + "],端口号:[" + port + "],当前提供服务的方法是：getProviderService";
    }

    @GetMapping("/getPort")
    public String getPort(){
        return this.port;
    }
}
