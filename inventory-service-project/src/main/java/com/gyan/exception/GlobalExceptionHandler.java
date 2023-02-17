package com.gyan.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		List<String> details = new ArrayList<>();
		details.add(String.format("Could not find the %s method for URL %s", ex.getHttpMethod(), ex.getRequestURL()));

		ApiError err = new ApiError(LocalDateTime.now(), HttpStatus.NOT_FOUND, "Method Not Found", details);

		return new ResponseEntity<Object>(err, err.getStatus());

	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(exception.getMessage());

		ApiError err = new ApiError(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR,
				request.getDescription(false), details);
		return new ResponseEntity<Object>(err, err.getStatus());
	}

	@ExceptionHandler(InventoryNotFoundException.class)
	public ResponseEntity<Object> handleProductNotFoundException(InventoryNotFoundException ex) {

		List<String> details = new ArrayList<>();
		details.add(ex.getMessage());

		ApiError err = new ApiError(LocalDateTime.now(), HttpStatus.NOT_FOUND, "Resource Not Found", details);

		return new ResponseEntity<Object>(err, err.getStatus());
	}
}
