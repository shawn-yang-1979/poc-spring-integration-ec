package com.shawnyang.poc.spring.integration.esb.transformer;

import org.springframework.integration.annotation.Transformer;

import com.shawnyang.poc.spring.integration.oms.i.ResponseStatus;

public class Erp2Oms {

	@Transformer
	public ResponseStatus transform(
			com.shawnyang.poc.spring.integration.erp.PostOrderResponse postOrderResponse) {

		ResponseStatus result = new ResponseStatus();
		result.setStatus(postOrderResponse.getStatus().toString());
		return result;
	}
}
