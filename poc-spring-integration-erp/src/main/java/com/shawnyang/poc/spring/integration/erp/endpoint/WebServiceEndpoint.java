package com.shawnyang.poc.spring.integration.erp.endpoint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.shawnyang.poc.spring.integration.erp.PostOrderRequest;
import com.shawnyang.poc.spring.integration.erp.PostOrderResponse;
import com.shawnyang.poc.spring.integration.erp.Status;

@Endpoint
public class WebServiceEndpoint {
	private Log log = LogFactory.getLog(WebServiceEndpoint.class);

	public static final String NAMESPACE_URI = "http://integration.spring.poc.shawnyang.com/erp";

	/**
	 * PayloadRoot is to pick the handler method based on the message’s
	 * namespace and localPart.
	 * 
	 * @param request
	 * @return
	 */
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
