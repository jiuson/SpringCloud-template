package com.yipinketang.zuul_gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * description: AppZuulGateway <br>
 * date: 2019/11/13 9:25 <br>
 * author: user <br>
 * version: 1.0 <br>
 */

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class AppZuulGateway {
}
