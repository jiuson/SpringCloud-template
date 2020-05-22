package com.jiuson.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * description: AppZuul <br>
 * date: 2019/12/11 11:20 <br>
 * author: jiuson <br>
 * version: 1.0 <br>
 */

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class AppZuul {

    public static void main(String[] args) {
        SpringApplication.run(AppZuul.class,args);
    }
}
