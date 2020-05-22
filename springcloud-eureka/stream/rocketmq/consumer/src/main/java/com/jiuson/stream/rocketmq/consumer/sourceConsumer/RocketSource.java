package com.jiuson.stream.rocketmq.consumer.sourceConsumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * description: RocketSource <br>
 * date: 2019/11/28 14:43 <br>
 * author: jiuson <br>
 * version: 1.0 <br>
 */
public interface RocketSource {

    String INPUT = "input1";

    @Input(INPUT)
    SubscribableChannel input();
}
