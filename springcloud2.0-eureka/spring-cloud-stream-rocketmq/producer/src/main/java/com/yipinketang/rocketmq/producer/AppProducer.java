package com.yipinketang.rocketmq.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * description: AppProducer <br>
 * date: 2019/11/27 11:55 <br>
 * author: jiuson <br>
 * version: 1.0 <br>
 */
@EnableEurekaClient
@SpringBootApplication
public class AppProducer {

    public static void main(String[] args) {
        SpringApplication.run(AppProducer.class, args);
    }
}
