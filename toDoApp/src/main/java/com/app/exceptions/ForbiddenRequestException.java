package com.app.exceptions;

@SuppressWarnings("serial")
public class ForbiddenRequestException extends RuntimeException {
	public ForbiddenRequestException(String message) {
		super(message);
	}
}
