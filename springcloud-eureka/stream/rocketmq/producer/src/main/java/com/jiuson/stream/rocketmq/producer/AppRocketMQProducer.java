package com.jiuson.stream.rocketmq.producer;

import com.jiuson.stream.rocketmq.producer.sourceProducer.RocketSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * description: AppProducer <br>
 * date: 2019/11/27 11:55 <br>
 * author: jiuson <br>
 * version: 1.0 <br>
 */
@EnableBinding(RocketSource.class)
@EnableEurekaClient
@SpringBootApplication
public class AppRocketMQProducer {

    public static void main(String[] args) {
        SpringApplication.run(AppRocketMQProducer.class, args);
    }
}
