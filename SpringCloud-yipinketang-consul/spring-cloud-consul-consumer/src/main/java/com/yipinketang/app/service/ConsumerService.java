package com.yipinketang.app.service;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consul-consumer")
public class ConsumerService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public Object getServiceFromProducer(@RequestParam(name = "name", required = false) String name){

        List<String> services = discoveryClient.getServices();
        System.out.println(services);
        String url = "http://producer/consul-producer/hello";
        return restTemplate.getForObject(url, String.class, name);
    }
}
