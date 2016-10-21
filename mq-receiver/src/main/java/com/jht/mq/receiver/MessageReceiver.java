package com.jht.mq.receiver;

import com.jht.mq.model.InventoryResponse;
import com.jht.mq.model.Order;
import com.jht.mq.service.OrderInventoryService;
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

	private static final String ORDER_RESPONSE_QUEUE = "order-response-queue";

	private static final String ORDER_QUEUE = "order-queue";

	@Autowired
	OrderInventoryService orderInventoryService;

	
	@JmsListener(destination = ORDER_QUEUE)
	public void receiveMessage(final Message<Order> message) throws JMSException {
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		MessageHeaders headers =  message.getHeaders();
		System.out.println("Application : headers received : {}" + headers);

		LOG.info("Application : headers received : {}", headers);
		Order order = message.getPayload();
		System.out.println("111" + order);
		LOG.info("Application : response received : {}", order);
		orderInventoryService.processOrder(order);
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}


}
