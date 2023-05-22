package com.codewave.demo.hktvmall.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.demo.hktvmall.Infra.response.ApiResponse;
import com.codewave.demo.hktvmall.controller.JsonPlaceHolderOperations;
import com.codewave.demo.hktvmall.service.JsonPlaceHolderService;

@RestController
@RequestMapping(value = "/jsonplaceholder/v1")
public class JsonPlaceHolderController implements JsonPlaceHolderOperations{

  @Autowired
  JsonPlaceHolderService jsonPlaceHolderService;

  @Override
  public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
    List<User> users = jsonPlaceHolderService.getAllUsers();

    ApiResponse<List<User>> response = ApiResponse.<List<User>>builder()
    .ok()
    .data(users)
    .build();
    return ResponseEntity.ok().body(response);
  }
  
}
