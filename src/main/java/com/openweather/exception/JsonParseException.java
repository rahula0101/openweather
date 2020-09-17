package com.openweather.exception;

public class JsonParseException extends RuntimeException {

	public JsonParseException() {
		super();
	}

	public JsonParseException(String message) {
		super(message);
	}

}
