package com.jht.mq.service;


import com.jht.mq.model.Order;

public interface OrderInventoryService {

	public void processOrder(Order order);
	
}
