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
        String msg="今天深圳天气大雨转暴雨";
//        rabbitTemplate.convertAndSend(RabbitConfig3.EXCHANGE_NAME,RabbitConfig3.ROUTING_KEY,msg);
    }
}
