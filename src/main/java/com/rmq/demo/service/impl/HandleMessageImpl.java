package com.rmq.demo.service.impl;

import com.rmq.demo.config.MQConfig;
import com.rmq.demo.dtos.CustomMessage;
import com.rmq.demo.service.HandleMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HandleMessageImpl implements HandleMessage {
    @Autowired
    private RabbitTemplate template;

    @Override
    public String publishMessage(CustomMessage message) {
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, message);

        return "Message Published";
    }

    @Override
    public String publishMessageTwo(CustomMessage message) {
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, message);

        return "Message Published 2";
    }
}
