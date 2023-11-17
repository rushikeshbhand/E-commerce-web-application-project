package com.ewa.project.exception;

@SuppressWarnings("serial")// This annotation tells the compiler to ignore warnings about a missing unique identifier
public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
