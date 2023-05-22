package com.codewave.demo.hktvmall.controller;


import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.codewave.demo.hktvmall.Infra.response.ApiResponse;

public interface JsonPlaceHolderOperations {

  @GetMapping(value = "/users")
  ResponseEntity<ApiResponse<List<User>>> getAllUsers();
  
}
