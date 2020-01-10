package com.yipinketang.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * description: AppRedis <br>
 * date: 2019/12/16 14:57 <br>
 * author: jiuson <br>
 * version: 1.0 <br>
 */

@SpringBootApplication
public class AppRedis {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(AppRedis.class, args);
        String[] beanDefinitionNames = configurableApplicationContext.getBeanDefinitionNames();
        System.out.println(beanDefinitionNames);
    }
}
