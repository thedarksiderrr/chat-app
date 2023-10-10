package com.chatapp.controller;

import com.chatapp.dto.ChatDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @MessageMapping("/")
    @SendTo("/chat/sendMessage")
    public ChatDTO sendMessage(@RequestBody ChatDTO chatDTO){
        return chatDTO;
    }


//    @MessageMapping("/chat")
//    @SendTo("/topic/public")
//    public ChatDTO addUser(@Payload ChatDTO chatDTO, SimpMessageHeaderAccessor headerAccessor){
//        //add username in websocket session
//        headerAccessor.getSessionAttributes().put("username", chatDTO.getSender());
//        return chatDTO;
//    }

}