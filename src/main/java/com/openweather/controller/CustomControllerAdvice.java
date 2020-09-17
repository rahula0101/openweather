package com.openweather.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

import com.openweather.exception.CustomErrorResponse;
import com.openweather.exception.JsonParseException;

@RestControllerAdvice
public class CustomControllerAdvice {

	@ExceptionHandler(value = JsonParseException.class)
	public ResponseEntity<CustomErrorResponse> handleJsonParseException(JsonParseException e) {
		CustomErrorResponse error = new CustomErrorResponse("UN_PARSABLE_JOSN",
				"Failed to process JSON returned by openweather.com");
		error.setTimestamp(LocalDateTime.now());
		error.setStatus((HttpStatus.BAD_REQUEST.value()));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = RestClientException.class)
	public ResponseEntity<CustomErrorResponse> handleRestClientException(RestClientException e) {
		CustomErrorResponse error = new CustomErrorResponse("NOT_FOUND", e.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setStatus((HttpStatus.NOT_FOUND.value()));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
