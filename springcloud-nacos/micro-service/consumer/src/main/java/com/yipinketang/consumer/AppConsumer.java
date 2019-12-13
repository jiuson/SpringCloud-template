package com.yipinketang.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * description: AppConsumer <br>
 * date: 2019/12/13 15:22 <br>
 * author: jiuson <br>
 * version: 1.0 <br>
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class AppConsumer {

    public static void main(String[] args) {
        SpringApplication.run(AppConsumer.class, args);
    }

    @Bean//通过注解的方式将RestTemplate对象注入到Spring的IOC容器中
    @LoadBalanced//开启RestTemplate实例的负载均衡器
    public RestTemplate generateRestTemplate(){
        return new RestTemplateBuilder().build();
    }
}
