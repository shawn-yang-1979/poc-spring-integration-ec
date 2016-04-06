package com.shawnyang.poc.spring.integration.esb.transformer;

import org.springframework.integration.annotation.Transformer;

import com.shawnyang.poc.spring.integration.oms.i.Response;

public class Erp2Oms {

	@Transformer
	public Response transform(com.shawnyang.poc.spring.integration.erp.PostOrderResponse postOrderResponse) {

		Response result = new Response();
		if (postOrderResponse.getStatus().equals(com.shawnyang.poc.spring.integration.erp.Status.OK)) {
			result.setStatus(Response.Status.OK);
		} else if (postOrderResponse.getStatus().equals(com.shawnyang.poc.spring.integration.erp.Status.ERROR)) {
			result.setStatus(Response.Status.ERROR);
			result.setMessage("Fail to post order to ERP.");
		}
		return result;
	}
}
