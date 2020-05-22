package com.jiuson.zipkin_monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * description: AppZipkinMonitor <br>
 * date: 2019/11/13 16:08 <br>
 * author: jiuson <br>
 * version: 1.0 <br>
 */
//开启eureka客户端
@EnableEurekaClient
//开启ZipkinServer
@EnableZipkinServer
@SpringBootApplication
public class AppZipkinMonitor {

    public static void main(String[] args) {
        SpringApplication.run(AppZipkinMonitor.class, args);
    }
}
