package com.agentic.codingrevolution.dto;

/**
 * Error response DTO for API error responses
 */
public class ErrorResponse {
    
    private String error;
    private String message;
    private int status;
    private String timestamp;
    private String path;
    
    public ErrorResponse() {
    }
    
    public ErrorResponse(String error, String message, int status, String timestamp, String path) {
        this.error = error;
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
        this.path = path;
    }
    
    public String getError() {
        return error;
    }
    
    public void setError(String error) {
        this.error = error;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getPath() {
        return path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    @Override
    public String toString() {
        return "ErrorResponse{" +
                "error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", status=" + status +
                ", timestamp='" + timestamp + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
