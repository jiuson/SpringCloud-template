package com.yipinketang.rocketmq.producer.sourceProducer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * description: RocketSource <br>
 * date: 2019/11/28 14:21 <br>
 * author: user <br>
 * version: 1.0 <br>
 */
public interface RocketSource {

    String OUTPUT = "output1";

    @Output(OUTPUT)
    MessageChannel output();


}
