package com.ameda.kevin.kafka.consumer;/*
*
@author ameda
@project kafka
*
*/

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageConsumer {


    @KafkaListener(topics = "ameda",groupId = "ameda-group-2024")
    public void consume(String message){
        log.info("message received: {}",message);
    }
}
