package com.nanshen.consumer.service;

import com.nanshen.consumer.config.RabbitConfig2;
import org.apache.catalina.Server;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 天气预报短信与邮箱通知
 */
@Service
public class ConsumerService2 {

    @RabbitListener(queues = {RabbitConfig2.EMAIL_QUEUE_NAME})
    public void receiveMsg(String msg){
        System.out.println(new Date().toString()+":"+msg);
    }
}
