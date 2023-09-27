package com.chatapp.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatDTO {

    private String content;
    private String sender;
    private MessageType type;
}
