package com.nanshen.consumer.service;

import com.nanshen.consumer.config.RabbitConfig3;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 天气预报短信与邮箱通知
 */
@Service
public class ConsumerService3 {

    @RabbitListener(queues = {RabbitConfig3.QUEUE2})
    public void receiveMsg(String msg){
        System.out.println(new Date().toString()+":"+msg);
    }
}
