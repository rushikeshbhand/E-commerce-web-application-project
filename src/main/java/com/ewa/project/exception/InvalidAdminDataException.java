package com.ewa.project.exception;

@SuppressWarnings("serial")// This annotation tells the compiler to ignore warnings about a missing unique identifier
public class InvalidAdminDataException extends RuntimeException {
    public InvalidAdminDataException(String message) {
        super(message);
    }
}