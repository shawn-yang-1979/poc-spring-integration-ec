package com.shawnyang.poc.spring.integration.store.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shawnyang.poc.spring.integration.store.i.Order;
import com.shawnyang.poc.spring.integration.store.i.OrderForm;
import com.shawnyang.poc.spring.integration.store.service.OrderMgr;

@Component
public class Checkout {

	@Autowired
	private OrderMgr ordermgr;

	public Order checkout(OrderForm form) {
		return ordermgr.createOrder(form);
	}

}
