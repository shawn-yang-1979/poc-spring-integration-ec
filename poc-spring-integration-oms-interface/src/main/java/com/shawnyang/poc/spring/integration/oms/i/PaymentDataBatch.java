package com.shawnyang.poc.spring.integration.oms.i;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class PaymentDataBatch implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<PaymentData> paymentData = new LinkedList<PaymentData>();

	public List<PaymentData> getPaymentData() {
		return paymentData;
	}

	public void setPaymentData(List<PaymentData> paymentData) {
		this.paymentData = paymentData;
	}

}
