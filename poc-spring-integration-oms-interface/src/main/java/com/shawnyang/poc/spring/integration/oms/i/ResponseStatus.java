package com.shawnyang.poc.spring.integration.oms.i;

import java.io.Serializable;

public class ResponseStatus implements Serializable {

	private static final long serialVersionUID = 1L;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
