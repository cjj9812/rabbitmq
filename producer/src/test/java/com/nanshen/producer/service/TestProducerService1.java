package com.nanshen.producer.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProducerService1 {

    @Autowired
    ProducerService1 producerService1;

    @Test
    public void testSendMessage(){
        producerService1.sendMessage();
    }
}
