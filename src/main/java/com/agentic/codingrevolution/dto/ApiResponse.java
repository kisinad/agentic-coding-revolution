package com.agentic.codingrevolution.dto;

/**
 * Response DTO for API responses
 */
public class ApiResponse {
    
    private String message;
    private int status;
    private String timestamp;
    
    public ApiResponse() {
    }
    
    public ApiResponse(String message, int status, String timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
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
    
    @Override
    public String toString() {
        return "ApiResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiResponse that = (ApiResponse) o;
        return status == that.status &&
                java.util.Objects.equals(message, that.message) &&
                java.util.Objects.equals(timestamp, that.timestamp);
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(message, status, timestamp);
    }
}
