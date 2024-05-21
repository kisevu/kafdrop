package com.ameda.kevin.kafka.producer.controller;/*
*
@author ameda
@project kafka
*
*/


import com.ameda.kevin.kafka.producer.dto.Worker;
import com.ameda.kevin.kafka.producer.service.MessagePublisher;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/prod")
public class ProduceController {
    private final MessagePublisher publisher;

//    @PostMapping("/publish/{message}")
//    public ResponseEntity<?> publish(@PathVariable("message") String message){
//        publisher.sendMessageToTopic(message);
//        return ResponseEntity
//                .ok()
//                .body("message sent successfully.");
//    }
    @PostMapping("/publish")
    public ResponseEntity<?> publishObject(@RequestBody Worker worker){
        publisher.sendObjectToTopic(worker);
        return ResponseEntity
                .ok()
                .body("object was sent to kafka successfully");
    }
}
