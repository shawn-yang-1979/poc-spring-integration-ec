package com.shawnyang.poc.spring.integration.oms.endpoint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shawnyang.poc.spring.integration.oms.i.Order;
import com.shawnyang.poc.spring.integration.oms.i.OrderForm;
import com.shawnyang.poc.spring.integration.oms.service.OrderMgr;

@RestController
@RequestMapping(path = "/order")
public class OrderEndpoint {
	private Log log = LogFactory.getLog(OrderEndpoint.class);

	@Autowired
	private OrderMgr orderMgr;

	@RequestMapping(method = RequestMethod.POST)
	public Order post(@RequestBody OrderForm orderForm) {
		log.debug(orderForm);

		Order order = orderMgr.createOrder(orderForm);

		log.debug(order);
		return order;
	}
}
