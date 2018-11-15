package com.yipinketang.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppConsumer {

    public static void main(String[] args){
        SpringApplication.run(AppConsumer.class, args);
    }
}
