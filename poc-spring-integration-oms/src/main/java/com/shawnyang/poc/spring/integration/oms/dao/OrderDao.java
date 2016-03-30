package com.shawnyang.poc.spring.integration.oms.dao;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.shawnyang.poc.spring.integration.oms.i.Order;
import com.shawnyang.poc.spring.integration.oms.i.OrderForm;
import com.shawnyang.poc.spring.integration.oms.i.OrderItem;
import com.shawnyang.poc.spring.integration.oms.i.ResponseStatus;

@Repository
public class OrderDao {
	private Log log = LogFactory.getLog(OrderDao.class);

	public Order createOrder(OrderForm orderForm) {
		// create order in OMS system
		Order order = new Order();
		order.setCustomer(orderForm.getCustomer());
		order.setComment(orderForm.getComment());
		order.setOrderSource(orderForm.getOrderSource());
		order.setNumber(UUID.randomUUID().toString());
		int qty = orderForm.getQty();
		for (int i = 0; i < qty; i++) {
			OrderItem newItem = new OrderItem();
			newItem.setNumber(i + 1);
			order.getItem().add(newItem);
		}

		// Sync OMS order to ERP
		RestTemplate restTemplate = new RestTemplate();

		log.debug(order);
		ResponseStatus result = restTemplate.postForObject("http://localhost:8080/erp/order", order,
				ResponseStatus.class);
		log.debug(result);

		return order;
	}

}
