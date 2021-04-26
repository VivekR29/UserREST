package com.vivekr29.rest.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UsernotfoundException extends RuntimeException {

	public UsernotfoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
