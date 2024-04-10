package com.rmq.demo.mapper;

import com.rmq.demo.dtos.MessageMenuDto;
import com.rmq.demo.models.MessageMenu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MessageMapper {
    public MessageMenu convertMessageMenuDtoToMessage(MessageMenuDto dto){
        return MessageMenu.builder()
                .messageFr(dto.getMessageFr())
                .messageEn(dto.getMessageEn())
                .id(UUID.randomUUID().toString())
                .objectEn(dto.getObjectEn())
                .objectFr(dto.getObjectFr())
                .build();
    }
}
