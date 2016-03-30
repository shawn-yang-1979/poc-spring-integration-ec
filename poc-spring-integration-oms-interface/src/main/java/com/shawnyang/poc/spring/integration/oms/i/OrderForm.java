package com.shawnyang.poc.spring.integration.oms.i;

import java.io.Serializable;

public class OrderForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String orderSource;

	private String customer;

	private int qty;

	private String comment;

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}

}
