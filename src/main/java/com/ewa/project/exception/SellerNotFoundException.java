package com.ewa.project.exception;

@SuppressWarnings("serial")// This annotation tells the compiler to ignore warnings about a missing unique identifier
public class SellerNotFoundException extends RuntimeException {
	public SellerNotFoundException(String message) {
        super(message);
    }
}
