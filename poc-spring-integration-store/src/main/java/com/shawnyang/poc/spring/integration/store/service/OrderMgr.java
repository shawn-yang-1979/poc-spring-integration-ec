package com.shawnyang.poc.spring.integration.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shawnyang.poc.spring.integration.store.dao.OrderDao;
import com.shawnyang.poc.spring.integration.store.i.Order;
import com.shawnyang.poc.spring.integration.store.i.OrderForm;

@Service
public class OrderMgr {

	@Autowired
	private OrderDao dao;

	public Order createOrder(OrderForm form) {
		return dao.createOrder(form);
	}

}
