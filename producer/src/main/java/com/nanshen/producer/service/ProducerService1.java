package com.nanshen.producer.service;

import com.nanshen.producer.config.RabbitConfig1;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerService1 {

    @Autowired
    RabbitTemplate rabbitTemplate;


    public void sendMessage(){
        String message="第一条信息";
        rabbitTemplate.convertAndSend(RabbitConfig1.QUEUE_NAME,message);
    }
}
