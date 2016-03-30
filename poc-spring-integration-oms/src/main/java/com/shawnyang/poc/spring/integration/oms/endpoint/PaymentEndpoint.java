package com.shawnyang.poc.spring.integration.oms.endpoint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shawnyang.poc.spring.integration.oms.i.PaymentDataBatch;

@RestController
@RequestMapping(path = "/payment")
public class PaymentEndpoint {
	private Log log = LogFactory.getLog(PaymentEndpoint.class);

	@RequestMapping(method = RequestMethod.POST)
	public void post(@RequestBody PaymentDataBatch paymentData) {
		log.debug(paymentData);
	}
}
