package com.chatapp.dto;

import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatDTO {

    private String content;
    private String sender;

    @Enumerated(EnumType.STRING)
    private MessageType type;
}
