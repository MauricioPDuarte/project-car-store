package com.mauriciopd.carstore.services.exceptions;

public class MyFileNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public MyFileNotFoundException(String msg) {
		super(msg);
	}

	public MyFileNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
