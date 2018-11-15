package com.yipinketang.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class AppConsumer {

    public static void main(String[] args){
        SpringApplication.run(AppConsumer.class, args);
    }

    @Bean//通过注解的方式将RestTemplate对象注入到Spring的IOC容器中
    @LoadBalanced
    public RestTemplate generateRestTemplate(){
        return new RestTemplateBuilder().build();
    }
}
