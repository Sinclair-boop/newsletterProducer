package com.rmq.demo.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageMenuDto {
    private String objectFr;

    public MessageMenuDto(String objectFr, String objectEn, String messageFr, String messageEn) {
        this.objectFr = objectFr;
        this.objectEn = objectEn;
        this.messageFr = messageFr;
        this.messageEn = messageEn;
    }

    private String objectEn;
    private String messageFr;
    private String messageEn;

    public MessageMenuDto(String messageFr, String messageEn) {
        this.messageFr = messageFr;
        this.messageEn = messageEn;
    }
}
