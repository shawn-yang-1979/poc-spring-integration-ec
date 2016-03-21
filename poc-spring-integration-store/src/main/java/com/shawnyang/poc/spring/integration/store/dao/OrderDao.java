package com.shawnyang.poc.spring.integration.store.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.shawnyang.poc.spring.integration.store.i.Order;
import com.shawnyang.poc.spring.integration.store.i.OrderForm;

@Repository
public class OrderDao {
	private Log log = LogFactory.getLog(OrderDao.class);

	public Order createOrder(OrderForm form) {
		log.debug(form);

		RestTemplate restTemplate = new RestTemplate();
		Order order = restTemplate.postForObject("http://localhost:8082/order", form, Order.class);

		log.debug(order);
		return order;
	}

}
