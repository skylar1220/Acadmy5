package com.example.demo.question;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "not found")
public class DataFoundNotException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DataFoundNotException(String str) {
		super(str);
	}

}
