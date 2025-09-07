package com.agentic.codingrevolution.exception;

import com.agentic.codingrevolution.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;

/**
 * Global exception handler for the application
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle custom API exceptions
     */
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleApiException(ApiException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                "API_ERROR",
                ex.getMessage(),
                ex.getStatusCode(),
                Instant.now().toString(),
                request.getDescription(false).replace("uri=", "")
        );
        return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
    }

    /**
     * Handle validation errors
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                "VALIDATION_ERROR",
                "Validation failed: " + ex.getBindingResult().getFieldError().getDefaultMessage(),
                HttpStatus.BAD_REQUEST.value(),
                Instant.now().toString(),
                request.getDescription(false).replace("uri=", "")
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }

    /**
     * Handle illegal argument exceptions
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                "INVALID_ARGUMENT",
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                Instant.now().toString(),
                request.getDescription(false).replace("uri=", "")
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }

    /**
     * Handle null pointer exceptions
     */
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(
            NullPointerException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                "NULL_POINTER_ERROR",
                "A null value was encountered where it was not expected",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                Instant.now().toString(),
                request.getDescription(false).replace("uri=", "")
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    /**
     * Handle all other exceptions
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                "INTERNAL_SERVER_ERROR",
                "An unexpected error occurred: " + ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                Instant.now().toString(),
                request.getDescription(false).replace("uri=", "")
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
