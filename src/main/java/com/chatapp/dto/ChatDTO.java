package com.chatapp.dto;

import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatDTO {

    private String content;
    private String sender;
//    private Timestamp timestamp;
    @Enumerated(EnumType.STRING)
    private MessageType type;
}
