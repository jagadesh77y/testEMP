package com.example.demo.exceptions;

public class ErrorMessage {
	private int statusCode;
	private java.util.Date timestamp;
	private String message;
	private String description;

	public ErrorMessage(int statusCode, java.util.Date date, String message, String description) {
		this.statusCode = statusCode;
		this.timestamp = date;
		this.message = message;
		this.description = description;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public java.util.Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}
}
