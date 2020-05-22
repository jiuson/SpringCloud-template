package com.jiuson.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient//开启Eureka客户端功能
@EnableFeignClients//开启feign客户端功能
public class AppConsumer {

    public static void main(String[] args){
        SpringApplication.run(AppConsumer.class, args);
    }

    @Bean//通过注解的方式将RestTemplate对象注入到Spring的IOC容器中
    @LoadBalanced//开启RestTemplate实例的负载均衡器
    public RestTemplate generateRestTemplate(){
        return new RestTemplateBuilder().build();
    }
}
