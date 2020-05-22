package com.yipinketang.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description: AppProvider <br>
 * date: 2019/12/13 9:23 <br>
 * author: jiuson <br>
 * version: 1.0 <br>
 */

@EnableDiscoveryClient
@SpringBootApplication
public class AppProvider {

    public static void main(String[] args) {
        SpringApplication.run(AppProvider.class, args);
    }
}
