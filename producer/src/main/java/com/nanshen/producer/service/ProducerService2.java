package com.nanshen.producer.service;

import com.nanshen.producer.config.RabbitConfig2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 天气发布订阅
 */
@Service
public class ProducerService2 {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMsg(){
        String msg="今天深圳天气大雨转暴雨";
        rabbitTemplate.convertAndSend(RabbitConfig2.EXCHANGE_NAME,RabbitConfig2.ROUTING_KEY,msg);
    }
}
