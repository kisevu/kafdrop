package com.ameda.kevin.kafka.producer.dto;/*
*
@author ameda
@project kafka
*
*/

import lombok.Data;

@Data
public class Worker {
    private int id;
    private String name;
    private  String email;
    private String contactNo;
}
