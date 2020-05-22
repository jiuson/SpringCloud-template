package com.jiuson.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//将服务作为eureka客户端注册到eureka注册中心
public class AppEurekaClient {

    public static void main(String[] args){
        SpringApplication.run(AppEurekaClient.class, args);
    }
}
