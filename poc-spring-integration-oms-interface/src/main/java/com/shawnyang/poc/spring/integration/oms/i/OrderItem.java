package com.shawnyang.poc.spring.integration.oms.i;

import java.io.Serializable;

public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
