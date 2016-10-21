package com.test;

import com.jht.mq.Application;
import com.jht.mq.mapper.UserMapper;
import com.jht.mq.model.Goods;
import com.jht.mq.model.Order;
import com.jht.mq.model.OrderStatus;
import com.jht.mq.model.User;
import com.jht.mq.sender.activemq.MessageSender;
import com.jht.mq.util.BasicUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ${huipei.x} on 2016/8/31.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class SendMessageTest {

    @Autowired
    MessageSender messageSender;
    @Autowired
    UserMapper userMapper;

    @Test
    public void sendOrder(){
        Order order=new Order();
        order.setOrderId(BasicUtil.getUniqueId());
        order.setStatus(OrderStatus.CREATED);
        order.setProductName("商品订单");
      /*  messageSender.sendMessage(order);*/

       messageSender.sendOrder(order);
        System.out.println("111"  );

    }

    @Test
    public void sendUser(){
        User user=new User();
        user.setId(1223345667);
        user.setUname("xiao");
        user.setAge("23");
        user.setPassword("111");
        user.setGid(2222);
       // messageSender.sendUser(user);
        userMapper.insert(user);
        System.out.println("111"  );

    }


    @Test
    public void Goods(){
        Goods goods=new Goods();
        goods.setGoodsName("2222");
        goods.setGoodsStatus("2");
        messageSender.sendGoods(goods);
        System.out.println("111"  );

    }

}
