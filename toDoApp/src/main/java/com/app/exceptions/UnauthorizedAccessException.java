package com.app.exceptions;

@SuppressWarnings("serial")
public class UnauthorizedAccessException extends RuntimeException {
	public UnauthorizedAccessException(String message) {
		super(message);
	}
}
