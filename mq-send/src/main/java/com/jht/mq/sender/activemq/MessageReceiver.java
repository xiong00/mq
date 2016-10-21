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


@Component
public class MessageReceiver {
	static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);

	private static final String ORDER_QUEUE = "order-queue";
  @Autowired
   OrderMapper orderMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	GoodsMapper goodsMapper;
	@JmsListener(destination = ORDER_QUEUE,concurrency="5-10")
	public <T> void receiveMessage(final Message<T> message) throws JMSException {
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		MessageHeaders headers =  message.getHeaders();
		System.out.println("Application : headers received : {}" + headers);

		LOG.info("Application : headers received : {}", headers);
		T t = message.getPayload();
		orderMapper.insert((Order) t);
		System.out.println("111" + (Order) t);
		userMapper.insert((User) t);
		goodsMapper.insert((Goods) t);
		//LOG.info("Application : response received : {}", (Order) t);
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}


}
*/
