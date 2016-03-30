package com.shawnyang.poc.spring.integration.erp.endpoint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.shawnyang.poc.spring.integration.erp.order.PostOrderRequest;
import com.shawnyang.poc.spring.integration.erp.order.PostOrderResponse;
import com.shawnyang.poc.spring.integration.erp.order.Status;

@Endpoint
public class OrderEndpoint {
	private Log log = LogFactory.getLog(OrderEndpoint.class);

	public static final String NAMESPACE_URI = "http://erp.integration.spring.poc.shawnyang.com/order";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "postOrderRequest")
	@ResponsePayload
	public PostOrderResponse postOrder(@RequestPayload PostOrderRequest request) {
		log.debug(request);

		PostOrderResponse response = new PostOrderResponse();
		response.setStatus(Status.OK);

		log.debug(response);
		return response;
	}
}
