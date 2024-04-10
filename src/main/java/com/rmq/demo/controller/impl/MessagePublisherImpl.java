package com.rmq.demo.controller.impl;

import com.rmq.demo.config.MQConfig;
import com.rmq.demo.controller.MessagePublisher;
import com.rmq.demo.dtos.CustomMessage;
import com.rmq.demo.dtos.Response.MainResponse;
import com.rmq.demo.dtos.Response.ResponseDto;
import com.rmq.demo.service.HandleMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MessagePublisherImpl implements MessagePublisher {
    private final HandleMessage handleMessage;
    @Autowired
    private RabbitTemplate template;

    @Override
    public ResponseEntity<ResponseDto> publishMessageController(CustomMessage message) {
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, message);

        log.info("===>request saving menu {}...", message);
        try{
            var messageMenuSave = handleMessage.publishMessage(message);
            if (messageMenuSave != null){
                return MainResponse.responseOk(messageMenuSave);
            }
            return MainResponse.responseNotFound("messages menu failed saving");
        }catch (Exception e){
            return MainResponse.responseError(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<ResponseDto> publishMessageTwoController(CustomMessage message) {
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, message);

        log.info("===>request saving menu {}...", message);
        try{
            var messageMenuSave = handleMessage.publishMessageTwo(message);
            if (messageMenuSave != null){
                return MainResponse.responseOk(messageMenuSave);
            }
            return MainResponse.responseNotFound("messages menu failed saving");
        }catch (Exception e){
            return MainResponse.responseError(e.getMessage());
        }
    }
}