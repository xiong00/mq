package com.jht.mq.activemq.example;

import com.alibaba.fastjson.JSON;
import com.jht.mq.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ${huipei.x} on 2016/9/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class exampleTest {
/*
     @Autowired
    private  MyMessageProducer producer;

    @Test
    public  void exre(  ){
        MessageInfo message = new MessageInfo();
        message.setHeader("header");
        message.setInfo("info");
        JSON.toJSONString(message);
        producer.sendMessage(message);
    }*/
}
