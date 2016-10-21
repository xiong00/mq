package com.jht.mq.receiver.rabbit;

import com.jht.mq.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by ${huipei.x} on 2016/9/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class RabbitTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    RabbitMessageReceiver receiver;
    @Test
    public void send() throws InterruptedException {
        rabbitTemplate.convertAndSend("jht-que", "Hello World!");
        receiver.getCountDownLatch().await(1, TimeUnit.SECONDS);
    }
}
