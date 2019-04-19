package com.nanshen.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig1 {

    public final static String QUEUE_NAME = "message_from_producer";



    // 声明队列
    @Bean(QUEUE_NAME)
    public Queue queue(){
        return new Queue(QUEUE_NAME);
    }


}

