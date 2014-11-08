package com.multivision.ehrms.exception;

public class DataSourceConnectivityFailedException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DataSourceConnectivityFailedException(String message) {
		this.message = message;
	}
}
