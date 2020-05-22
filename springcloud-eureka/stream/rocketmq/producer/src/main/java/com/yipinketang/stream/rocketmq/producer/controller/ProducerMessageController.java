package com.jiuson.stream.rocketmq.producer.controller;

import com.jiuson.stream.rocketmq.producer.sourceProducer.SourceProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: ProducerMessageController <br>
 * date: 2019/11/27 15:57 <br>
 * author: jiuson <br>
 * version: 1.0 <br>
 */
@RestController
@RequestMapping("/sourceProducer")
public class ProducerMessageController {

    @Autowired
    private SourceProducer sourceProducer;

    @PostMapping("/msg")
    public Object sourceProducer(@RequestBody String msg) {
        this.sourceProducer.sendMessage(msg);
        return "this msg send to test-topic success!";
    }
}
