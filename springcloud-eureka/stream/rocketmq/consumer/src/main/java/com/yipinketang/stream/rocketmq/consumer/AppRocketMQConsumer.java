package com.yipinketang.stream.rocketmq.consumer;

import com.yipinketang.stream.rocketmq.consumer.sourceConsumer.RocketSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * description: AppRocketMQConsumer <br>
 * date: 2019/11/28 14:42 <br>
 * author: jiuson <br>
 * version: 1.0 <br>
 */

@EnableBinding(RocketSource.class)
@EnableEurekaClient
@SpringBootApplication
public class AppRocketMQConsumer {

    public static void main(String[] args) {
        SpringApplication.run(AppRocketMQConsumer.class, args);
    }
}
