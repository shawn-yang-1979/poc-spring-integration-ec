package com.shawnyang.poc.spring.integration.endpoint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

import com.shawnyang.poc.spring.integration.domain.Order;
import com.shawnyang.poc.spring.integration.domain.OrderItem;

@MessageEndpoint
public class OnlineOrder {

	private Log log = LogFactory.getLog(OnlineOrder.class);

	@ServiceActivator(inputChannel = "onlineOrderRequest", outputChannel = "onlineOrderReply")
	public Order create(Message<Order> inboundMessage) {
		Order newOrder = new Order();
		OrderItem newItem1 = new OrderItem();
		newItem1.setOrderNumber(1);
		OrderItem newItem2 = new OrderItem();
		newItem2.setOrderNumber(2);
		newOrder.setNumber(1);
		newOrder.getItems().add(newItem1);
		newOrder.getItems().add(newItem2);
		return newOrder;
	}

	// @Headers Map<String, Object> headerMap
}
