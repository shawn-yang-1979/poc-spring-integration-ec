package com.shawnyang.poc.spring.integration.oms.i;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PaymentData implements Serializable {

	private static final long serialVersionUID = 1L;
	private String creditCardNumber;
	private Date date;
	private BigDecimal amount;

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}