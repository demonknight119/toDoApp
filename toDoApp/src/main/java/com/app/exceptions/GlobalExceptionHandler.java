package com.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse> handleBadRequestsException(BadRequestException ex) {

		ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
		// below given is the alternate but equivalent return statement
		// return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(ForbiddenRequestException.class)
	public ResponseEntity<ErrorResponse> handleForbiddenRequestsException(ForbiddenRequestException ex) {

		ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.FORBIDDEN.value());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {

		ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UnauthorizedAccessException.class)
	public ResponseEntity<ErrorResponse> handleUnauthorizedAccessException(UnauthorizedAccessException ex) {

		ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.UNAUTHORIZED.value());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseEntity<ErrorResponse> handleDuplicateEmailException(DuplicateEmailException ex) {

		ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.CONFLICT.value());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleOtherExceptions(Exception ex) {

		ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
