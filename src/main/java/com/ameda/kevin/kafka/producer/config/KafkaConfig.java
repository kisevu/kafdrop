package com.ameda.kevin.kafka.producer.config;/*
*
@author ameda
@project kafka
*
*/

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic createTopic(){
        return new NewTopic("kevin",5,(short) 1);
    }
}
