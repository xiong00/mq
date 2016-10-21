package com.jht.test;

import javax.jms.JMSException;

import com.jht.mq.Application;
import com.jht.mq.model.InventoryResponse;
import com.jht.mq.model.Order;
import com.jht.mq.model.OrderStatus;
import com.jht.mq.receiver.MessageReceiver;
import com.jht.mq.receiver.MessageSender;
import com.jht.mq.util.BasicUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;


/**
 * Created by ${huipei.x} on 2016/8/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)

public class ReceiverMessageTest {


    @Autowired
    MessageReceiver messageReceiver;
   /* @Autowired
    OrderService orderService ;*/

    @Autowired
    MessageSender messageSender;
   @Test
    public void receiveMessage() throws JMSException {
      /* Map<String, Order> map= orderService.getAllOrders();
       System.out.println("111" + map.get("productName")  );*/
          /* messageReceiver.receiveMessage(message);*/
       /*org.springframework.messaging.Message<InventoryResponse> message = null;
        messageReceiver.receiveMessage(message);
        System.out.println("111"  );*/

    }


    @Test
    public void sendMessage() throws JMSException{
        InventoryResponse inventoryResponse=new InventoryResponse();
        inventoryResponse.setOrderId("1");
        inventoryResponse.setComment("rrrr");
        messageSender.sendMessage(inventoryResponse);
    }
}
