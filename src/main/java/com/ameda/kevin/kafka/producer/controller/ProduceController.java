package com.ameda.kevin.kafka.producer.controller;/*
*
@author ameda
@project kafka
*
*/

import com.ameda.kevin.kafka.producer.service.MessagePublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/prod")
public class ProduceController {
    private final MessagePublisher publisher;

    @PostMapping("/publish/{message}")
    public ResponseEntity<?> publish(@PathVariable("message") String message){
        publisher.sendMessageToTopic(message);
        return ResponseEntity
                .ok()
                .body("message sent successfully.");
    }
}
