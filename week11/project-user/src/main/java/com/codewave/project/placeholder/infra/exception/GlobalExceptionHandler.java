package com.codewave.project.placeholder.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;

import com.codewave.project.placeholder.infra.response.ApiResponse;

// @RestControllerAdvice
public class GlobalExceptionHandler {
  // if the thrown exception is instanceOf RestClientException
  @ExceptionHandler(value = { RestClientException.class })
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResponse<Void> restClientExceptionHandler(Exception e) {
    return ApiResponse.<Void>builder()
        .error(new WaveRestClientException())
        .data(null)
        .build();
  }

  @ExceptionHandler(value = { ResourceAccessException.class })
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResponse<Void> restResourceAccessExceptionHandler(Exception e) {
    return ApiResponse.<Void>builder()
        .error(new WaveResourceAccessException())
        .data(null)
        .build();
  }

  

}
