package com.nanshen.producer.service;

import com.nanshen.producer.config.RabbitConfig3;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 天气预报短信与邮箱通知
 */
@Service
public class ProducerService3 {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMsg(){
        String msg="Q1:key1";
        rabbitTemplate.convertAndSend(RabbitConfig3.EXCHANGE_NAME,RabbitConfig3.Q1_ROUTING_KEY,msg);
        String msg2="Q1:key2";
        rabbitTemplate.convertAndSend(RabbitConfig3.EXCHANGE_NAME,RabbitConfig3.Q1_ROUTING_KEY2,msg2);
        String msg3="Q2:key3";
        rabbitTemplate.convertAndSend(RabbitConfig3.EXCHANGE_NAME,RabbitConfig3.Q2_ROUTING_KEY,msg3);
    }
}
