package com.nanshen.producer.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 路由方式
 */
@Configuration
public class RabbitConfig3 {

    public static final String QUEUE1="queue1";
    public static final String QUEUE2="queue2";
    public static final String EXCHANGE_NAME="direct-Exchange";
    public static final String Q1_ROUTING_KEY="orange";
    public static final String Q2_ROUTING_KEY="black";


    /**
     * 邮箱队列
     * @return
     */
    @Bean(QUEUE1)
    public Queue emailQueue(){
        //队列默认是持久化的
        return new Queue(QUEUE1);
    }

    /**
     * 短信队列
     * @return
     */
    @Bean(QUEUE2)
    public Queue phoneQueue(){
        //队列默认是持久化的
        return new Queue(QUEUE2);
    }


    /**
     * 声明交换机
     * @return
     */
    @Bean(EXCHANGE_NAME)
    public Exchange exchange(){
        return ExchangeBuilder.directExchange(EXCHANGE_NAME).durable(true).build();
    }


    /**
     * 绑定邮箱队列跟交换机
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding bindingQ1Exchange(@Qualifier(QUEUE1)Queue queue,@Qualifier(EXCHANGE_NAME) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(Q1_ROUTING_KEY).noargs();
    }


    /**
     * 绑定手机短信队列跟交换机
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding bindingQ2Exchange(@Qualifier(QUEUE2)Queue queue,@Qualifier(EXCHANGE_NAME) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(Q2_ROUTING_KEY).noargs();
    }
}
