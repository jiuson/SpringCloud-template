package com.yipinketang.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * description: AppZipkin <br>
 * date: 2019/12/15 20:10 <br>
 * author: jiuson <br>
 * version: 1.0 <br>
 */

@EnableDiscoveryClient
@EnableZipkinServer
@SpringBootApplication
public class AppZipkin {

    public static void main(String[] args) {
        SpringApplication.run(AppZipkin.class, args);
    }
}
