package com.shawnyang.poc.spring.integration.oms.i;

import java.io.Serializable;

public class Response implements Serializable {

	public static enum Status {
		OK, ERROR
	}

	private static final long serialVersionUID = 1L;
	private Status status;
	private String message;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
