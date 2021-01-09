package org.javaonfly.springframework.sessionweb.controller.exception;

import java.util.Date;
import java.util.List;

import org.javaonfly.springframework.sessionweb.service.exception.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

	@ExceptionHandler(BindException.class)
	public ResponseEntity<List> handleBindException(BindException ex, WebRequest request) {
		logger.error("Entered Bind violation");
		StringBuilder errorMessage = new StringBuilder();
		ex.getAllErrors().forEach(error -> errorMessage.append(error.getDefaultMessage() + ". "));
		return new ResponseEntity(
				ExceptionResponse.builder().timeStamp(new Date()).message("Validation failed")
						.details(errorMessage.toString()).uri(request.getDescription(false)).build(),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<List> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request) {
		logger.error("Entered Product violation");
		return new ResponseEntity(
				ExceptionResponse.builder().timeStamp(new Date()).message(ex.getMessage())
						.details(request.getDescription(false)).uri(request.getDescription(false)).build(),
				HttpStatus.BAD_REQUEST);
	}

}