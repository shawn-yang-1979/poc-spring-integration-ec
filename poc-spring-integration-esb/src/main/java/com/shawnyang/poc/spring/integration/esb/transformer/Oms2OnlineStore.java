package com.shawnyang.poc.spring.integration.esb.transformer;

import org.springframework.integration.annotation.Transformer;

import com.google.gson.Gson;
import com.shawnyang.poc.spring.integration.store.i.Order;

public class Oms2OnlineStore {

	@Transformer
	public Order transform(com.shawnyang.poc.spring.integration.oms.i.Order in) {
		Gson gson = new Gson();
		String json = gson.toJson(in);
		Order out = gson.fromJson(json, Order.class);
		return out;
	}

}
