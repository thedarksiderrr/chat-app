//package com.chatapp.controller;
//
//import com.chatapp.dto.ChatDTO;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//@RestController
//public class ChatSSE {
//    Map<String, SseEmitter> activeEmitters = new HashMap<>();
//
//    @PostMapping(value = "/postMessage", consumes = MediaType.ALL_VALUE)
//    void sendNewLocationUpdate(@RequestBody ChatDTO chatDTO) {
//        for (String userID : activeEmitters.keySet()) {
//            try {
//                if (activeEmitters.get(userID) != null)
//                    activeEmitters.get(userID)
//                            .send(SseEmitter.event()
//                                    .name("MESSAGES")
//                                    .data(chatDTO));
//            } catch (IOException e) {
//                e.printStackTrace();
//                activeEmitters.remove(userID);
//            }
//        }
//
//    }
//
//    @GetMapping(value = "/getMessages", consumes = MediaType.ALL_VALUE)
//    SseEmitter getLocationSubscribe(@RequestParam String userID) {
//        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
//        try {
//            emitter.send(SseEmitter.event().name("MESSAGES"));
//            emitter.onCompletion(() -> activeEmitters.remove(emitter));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        activeEmitters.put(userID, emitter);
//        return emitter;
//    }
//}
