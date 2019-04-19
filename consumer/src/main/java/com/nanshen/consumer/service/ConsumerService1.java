package com.nanshen.consumer.service;

import com.nanshen.consumer.config.RabbitConfig1;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 工作队列方式
 */
@Component
public class ConsumerService1 {

    /**
     *  消费队列信息，下面两个参数都能获取队列信息
     * @param msg
     * @param message
     */
    @RabbitListener(queues = {RabbitConfig1.QUEUE_NAME})
    public void receiveMessage(String msg, Message message){
        System.out.println("接收到的消息："+msg);
        System.out.println("接收到的消息："+new String(message.getBody()));
    }
}
