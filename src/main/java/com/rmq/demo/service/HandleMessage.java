package com.rmq.demo.service;

import com.rmq.demo.dtos.CustomMessage;

public interface HandleMessage {
    String publishMessage(CustomMessage message);
    String publishMessageTwo(CustomMessage message);
}
