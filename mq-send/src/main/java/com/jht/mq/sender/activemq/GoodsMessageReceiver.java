/*
package com.jht.mq.sender.activemq;

import com.jht.mq.mapper.GoodsMapper;
import com.jht.mq.mapper.OrderMapper;
import com.jht.mq.mapper.UserMapper;
import com.jht.mq.model.Goods;
import com.jht.mq.model.Order;
import com.jht.mq.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

*/
/**
 * Created by ${huipei.x} on 2016/9/1.
 *//*

@Component
public class GoodsMessageReceiver {

    static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);

    private static final String ORDER_QUEUE = "order-queue";
    @Autowired
    GoodsMapper goodsMapper;
    @JmsListener(destination = "goo",concurrency="5-10")
    public  void receiveMessage(final Message<Goods> message) throws JMSException {
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        MessageHeaders headers =  message.getHeaders();
        System.out.println("Application : headers received : {}" + headers);

        LOG.info("Application : headers received : {}", headers);
        Goods goods = message.getPayload();
        goodsMapper.insert(goods);
        //LOG.info("Application : response received : {}", (Order) t);
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

}
*/
