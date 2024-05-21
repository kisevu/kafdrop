package com.ameda.kevin.kafka.consumer;/*
*
@author ameda
@project kafka
*
*/


import com.ameda.kevin.kafka.producer.dto.Worker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageConsumer {


    @KafkaListener(topics = "kevin",groupId = "ameda-group-2024")
    public void consume(Worker worker){
        log.info("Email:{} and Contact number:{}",worker.getEmail(),worker.getContactNo());
    }
}
