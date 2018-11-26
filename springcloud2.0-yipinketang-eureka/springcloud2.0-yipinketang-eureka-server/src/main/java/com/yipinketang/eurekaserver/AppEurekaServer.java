package com.yipinketang.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//将服务作为eureka注册中心
public class AppEurekaServer {

    public static void main(String[] args){
        SpringApplication.run(AppEurekaServer.class, args);
    }

}
