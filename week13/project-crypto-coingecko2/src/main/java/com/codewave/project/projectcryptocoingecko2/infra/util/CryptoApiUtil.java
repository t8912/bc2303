package com.codewave.project.projectcryptocoingecko2.infra.util;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class CryptoApiUtil {

    private CryptoApiUtil() {
        // Private constructor to prevent instantiation
    }

    public static HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // Add any additional headers as needed
        return headers;
    }
}

