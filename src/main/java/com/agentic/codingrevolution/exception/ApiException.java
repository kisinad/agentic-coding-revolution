package com.agentic.codingrevolution.exception;

/**
 * Custom exception for API errors
 */
public class ApiException extends RuntimeException {
    
    private final int statusCode;
    
    public ApiException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
    
    public ApiException(String message, int statusCode, Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
    }
    
    public int getStatusCode() {
        return statusCode;
    }
}
