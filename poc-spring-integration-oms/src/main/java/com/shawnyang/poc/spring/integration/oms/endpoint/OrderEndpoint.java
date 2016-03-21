package com.shawnyang.poc.spring.integration.oms.endpoint;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shawnyang.poc.spring.integration.store.i.Order;
import com.shawnyang.poc.spring.integration.store.i.OrderForm;
import com.shawnyang.poc.spring.integration.store.i.OrderItem;

@RestController
@RequestMapping(path = "/order")
public class OrderEndpoint {
	
	private Log log = LogFactory.getLog(OrderEndpoint.class);

	@RequestMapping(method = RequestMethod.POST)
	public Order post(@RequestBody OrderForm orderForm) {
		log.debug(orderForm);
		
		Order order = new Order();
		order.setCustomer(orderForm.getCustomer());
		order.setComment(orderForm.getComment());
		order.setNumber(UUID.randomUUID().toString());
		int qty = orderForm.getQty();
		for (int i = 0; i < qty; i++) {
			OrderItem newItem = new OrderItem();
			newItem.setNumber(i + 1);
			order.getItem().add(newItem);
		}
		
		log.debug(order);
		return order;
	}
}
