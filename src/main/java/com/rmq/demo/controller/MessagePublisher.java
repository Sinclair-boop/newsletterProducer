package com.rmq.demo.controller;

import com.rmq.demo.dtos.CustomMessage;
import com.rmq.demo.dtos.Response.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/apiv1/newsletter/producer")
public interface MessagePublisher {
    @PostMapping("/publish")
    ResponseEntity<ResponseDto> publishMessageController(@RequestBody CustomMessage message);
    @PostMapping("/publishs")
    ResponseEntity<ResponseDto> publishMessageTwoController(@RequestBody CustomMessage message);
}
