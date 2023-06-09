package com.codewave.project.projectcryptopolygon.infra.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class CryptoApiUtil {
    public static HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
