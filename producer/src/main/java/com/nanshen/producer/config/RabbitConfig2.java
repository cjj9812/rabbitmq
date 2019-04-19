package com.nanshen.producer.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 发布订阅方式配置
 */
@Configuration
public class RabbitConfig2 {

    public static final String EMAIL_QUEUE_NAME="Email-Queue";
    public static final String SMS_QUEUE_NAME="SMS-Queue";
    public static final String EXCHANGE_NAME="fanout-Exchange";
    public static final String ROUTING_KEY="";


    /**
     * 邮箱队列
     * @return
     */
    @Bean(EMAIL_QUEUE_NAME)
    public Queue emailQueue(){
        //队列默认是持久化的
        return new Queue(EMAIL_QUEUE_NAME);
    }

    /**
     * 短信队列
     * @return
     */
    @Bean(SMS_QUEUE_NAME)
    public Queue phoneQueue(){
        //队列默认是持久化的
        return new Queue(SMS_QUEUE_NAME);
    }


    /**
     * 声明交换机
     * @return
     */
    @Bean(EXCHANGE_NAME)
    public Exchange exchange(){
        return ExchangeBuilder.fanoutExchange(EXCHANGE_NAME).durable(true).build();
    }


    /**
     * 绑定邮箱队列跟交换机
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding bindingEmaliExchange(@Qualifier(EMAIL_QUEUE_NAME)Queue queue,@Qualifier(EXCHANGE_NAME) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY).noargs();
    }


    /**
     * 绑定手机短信队列跟交换机
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding bindingPhoneExchange(@Qualifier(SMS_QUEUE_NAME)Queue queue,@Qualifier(EXCHANGE_NAME) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY).noargs();
    }
}
