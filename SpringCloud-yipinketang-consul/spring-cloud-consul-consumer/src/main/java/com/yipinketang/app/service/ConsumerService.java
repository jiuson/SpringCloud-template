package com.yipinketang.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consul-consumer")
public class ConsumerService {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public Object getServiceFromProducer(@RequestParam(name = "name", required = false) String name){
        String url = "http://producer/consul-producer/hello";
        return restTemplate.getForObject(url, String.class, name);
    }
}
