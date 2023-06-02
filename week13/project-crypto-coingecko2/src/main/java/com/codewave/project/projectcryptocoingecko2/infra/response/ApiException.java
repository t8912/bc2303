package com.codewave.project.projectcryptocoingecko2.infra.response;


import java.io.IOException;

public class ApiException extends RuntimeException {
    private final ApiError apiError;

    public ApiException(ApiError apiError) {
        this.apiError = apiError;
    }

    public ApiException(String message, IOException e) {
        super(message, e);
        this.apiError = new ApiError();
    }

    public ApiError getApiError() {
        return apiError;
    }
}


/* 
import java.io.IOException;

public class ApiException extends RuntimeException {
    private final ApiError apiError;

    public ApiException(ApiError apiError) {
        this.apiError = apiError;
    }


    public ApiException(String string, IOException e) {
    }

    public ApiError getApiError() {
        return apiError;
    }
}
*/

