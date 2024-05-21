package com.ameda.kevin.kafka.producer.service;/*
*
@author ameda
@project kafka
*
*/

import com.ameda.kevin.kafka.producer.dto.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessagePublisher {
    private final KafkaTemplate<String,Object> kafkaTemplate;


//    public void sendMessageToTopic(String message){
//        kafkaTemplate.send("ameda",message);
//    }

    public void sendObjectToTopic(Worker worker){
        kafkaTemplate.send("kevin",worker);
    }
}
