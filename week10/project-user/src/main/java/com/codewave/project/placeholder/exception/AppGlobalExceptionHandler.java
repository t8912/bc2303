package com.codewave.project.placeholder.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.codewave.project.placeholder.infra.exception.GlobalExceptionHandler;

@RestControllerAdvice
public class AppGlobalExceptionHandler extends GlobalExceptionHandler {

}
