package com.jiuson.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppProvider {

    public static void main(String[] args){
        SpringApplication.run(AppProvider.class, args);
    }
}
