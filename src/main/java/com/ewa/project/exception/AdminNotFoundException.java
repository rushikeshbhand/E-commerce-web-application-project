package com.ewa.project.exception;

@SuppressWarnings("serial")// This annotation tells the compiler to ignore warnings about a missing unique identifier
public class AdminNotFoundException extends RuntimeException {
    public AdminNotFoundException(String message) { //Creates a new exception for when an admin is not found
        super(message); // Use this message when creating the exception
    }
}