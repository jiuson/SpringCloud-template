package com.yioinketang.rocketmq.consumer.sourceConsumer;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * description: SourceConsumer <br>
 * date: 2019/11/28 14:50 <br>
 * author: user <br>
 * version: 1.0 <br>
 */
@Component
public class SourceConsumer {

    @StreamListener(RocketSource.INPUT)
    public void input1Comsuner(String message) {
        System.out.println("topic:test-topic-1的消息已经被消费啦，消息内容是：" + message);
    }
}
