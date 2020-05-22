package com.jiuson.stream.rocketmq.producer.sourceProducer;

import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * description: SourceProducer <br>
 * date: 2019/11/27 15:52 <br>
 * author: jiuson <br>
 * version: 1.0 <br>
 */
@Component
public class SourceProducer {

    @Autowired
    private RocketSource rocketSource;

    public void sendMessage(String msg) {
        String payload = msg;
        Map<String, Object> headers = new HashMap<>();
        headers.put(MessageConst.PROPERTY_TAGS, "testTag");
        MessageHeaders messageHeaders = new MessageHeaders(headers);
        Message<String> message = MessageBuilder.createMessage(payload, messageHeaders);
        this.rocketSource.output().send(message);
    }
}
