package com.shawnyang.poc.spring.integration.esb.transformer;

import org.springframework.integration.annotation.Transformer;

import com.google.gson.Gson;
import com.shawnyang.poc.spring.integration.oms.i.OrderForm;

public class OnlineStore2Oms {

	@Transformer
	public OrderForm transform(com.shawnyang.poc.spring.integration.store.i.OrderForm storeOrderFormIn) {
		Gson gson = new Gson();
		String json = gson.toJson(storeOrderFormIn);
		OrderForm omsOrderFormOut = gson.fromJson(json, OrderForm.class);
		return omsOrderFormOut;
	}

}
