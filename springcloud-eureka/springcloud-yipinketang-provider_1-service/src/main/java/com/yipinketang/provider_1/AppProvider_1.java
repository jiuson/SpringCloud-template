package com.yipinketang.provider_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description: AppProvider_1 <br>
 * date: 2019/11/12 20:22 <br>
 * author: user <br>
 * version: 1.0 <br>
 */

@EnableDiscoveryClient
@SpringBootApplication
public class AppProvider_1 {

    public static void main(String[] args) {
        SpringApplication.run(AppProvider_1.class, args);
    }
}
