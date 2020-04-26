package com.photoshop.photoapp.app.ws.exceptions;

public class UserServiceException extends RuntimeException {
	
	private static final long serialVersionUID=76743266877879L;
	
	public UserServiceException(String message) {
		super(message);
	}

}
