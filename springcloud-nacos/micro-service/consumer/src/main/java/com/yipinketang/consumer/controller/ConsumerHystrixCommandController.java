package com.yipinketang.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * description: ConsumerHystrixCommandController <br>
 * 通过Hystrix实现服务降级保护，避免服务雪崩的发生
 * date: 2019/12/15 17:49 <br>
 * author: jiuson <br>
 * version: 1.0 <br>
 */
@RestController
public class ConsumerHystrixCommandController {

    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String consumerName;

    @Autowired
    private RestTemplate restTemplate;

    private Integer requestNum = 0;//来自客户端的总请求数，通过不同的浏览器访问，可以证明ConsumerController是Singleton

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/getServiceFromProviderByServerIpOfHystrix")
    public String getServiceFromProviderByServerIpOfHystrix(){
        System.out.println("当前线程名称：" + Thread.currentThread().getName());
        String result = "这是consumer service 的getServiceFromProviderByDiscoveryClient方法,本次是第[" + requestNum +
                "]次请求，provider service返回的数据是:";
        //通过ip+port方式不需要开启负载均衡器，因为已经指定了服务地址
        String url = "http://127.0.0.1:8020/getProviderService";
        result += restTemplate.getForObject(url, String.class);
        return result;
    }

    public String fallback(){
        return "服务器忙，请稍后再试......";
    }
}
