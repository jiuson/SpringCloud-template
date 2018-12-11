package com.yipinketang.app.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consul-producer")
public class ProducerService {

    @GetMapping("/hello")
    public Object hello(@RequestParam(required = false, name = "name") String name){

        return "The request from: " + name;
    }
}
