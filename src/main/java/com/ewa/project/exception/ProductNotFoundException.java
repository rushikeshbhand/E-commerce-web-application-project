package com.ewa.project.exception;

@SuppressWarnings("serial")// This annotation tells the compiler to ignore warnings about a missing unique identifier
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
