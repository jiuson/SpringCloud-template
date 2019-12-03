package com.yipinketang.zipkin_monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * description: AppZipkinMonitor <br>
 * date: 2019/11/13 16:08 <br>
 * author: user <br>
 * version: 1.0 <br>
 */

//@EnableEurekaClient
@EnableZipkinServer
@SpringBootApplication
public class AppZipkinMonitor {

    public static void main(String[] args) {
        SpringApplication.run(AppZipkinMonitor.class, args);
    }
}
