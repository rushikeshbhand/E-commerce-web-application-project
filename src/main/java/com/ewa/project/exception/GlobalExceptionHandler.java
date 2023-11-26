package com.ewa.project.exception;

import org.springframework.http.HttpStatus;
import java.util.Date;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//This class provides a way to handle exceptions globally for all controllers
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(AdminNotFoundException.class)  // Handle specific exception: AdminNotFoundException
    public ResponseEntity<?> handleAdminNotFoundException(AdminNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));// Create error details with timestamp, exception message, and request details
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND); // Return a response entity with error details and HTTP status NOT_FOUND
    }
	
	@ExceptionHandler(CustomerNotFoundException.class)// Handle specific exception: CustomerNotFoundException
    public ResponseEntity<?> handleCustomerNotFoundException(CustomerNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)// Handle specific exception: CategoryNotFoundException
    public ResponseEntity<?> handleCategoryNotFoundException(CategoryNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(ProductNotFoundException.class)// Handle specific exception: ProductNotFoundException
    public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(InvalidAdminDataException.class)// Handle specific exception: InvalidAdminDataException
    public ResponseEntity<?> handleInvalidAdminDataException(InvalidAdminDataException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(SellerNotFoundException.class)// Handle specific exception: SellerNotFoundException
    public ResponseEntity<?> handleSellerNotFoundException(SellerNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(Exception.class)// Handle general exception for any other unexpected issues
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
    	// Create error details with timestamp, exception message, and request details
    	ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        // Return a response entity with error details and HTTP status INTERNAL_SERVER_ERROR
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}