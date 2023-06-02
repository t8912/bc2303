package com.codewave.project.projectcryptocoingecko2.infra.response;


public class ApiError {
    private int statusCode;
    private String message;
    // Add more fields as needed

    // Generate getters and setters
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
