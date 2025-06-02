package com.sdet.demo.controller;

public class ErrorResponse {
    private String error;
    private String message;
    private int status;
    
    public ErrorResponse(String error, String message, int status) {
        this.error = error;
        this.message = message;
        this.status = status;
    }
    
    // Getters
    public String getError() { return error; }
    public String getMessage() { return message; }
    public int getStatus() { return status; }
    
    // Setters
    public void setError(String error) { this.error = error; }
    public void setMessage(String message) { this.message = message; }
    public void setStatus(int status) { this.status = status; }
}
