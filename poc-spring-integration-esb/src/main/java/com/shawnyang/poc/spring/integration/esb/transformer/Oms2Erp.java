package com.shawnyang.poc.spring.integration.esb.transformer;

import org.springframework.integration.annotation.Transformer;

import com.google.gson.Gson;
import com.shawnyang.poc.spring.integration.erp.Order;
import com.shawnyang.poc.spring.integration.erp.PostOrderRequest;

public class Oms2Erp {

	@Transformer
	public PostOrderRequest transform(com.shawnyang.poc.spring.integration.oms.i.Order omsOrder) {
		Gson gson = new Gson();
		String json = gson.toJson(omsOrder);
		Order erpOrder = gson.fromJson(json, Order.class);
		PostOrderRequest result = new PostOrderRequest();
		result.setOrder(erpOrder);
		return result;
	}

}
