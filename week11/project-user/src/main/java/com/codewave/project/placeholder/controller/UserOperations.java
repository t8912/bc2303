package com.codewave.project.placeholder.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.codewave.project.placeholder.infra.response.ApiResponse;
import com.codewave.project.placeholder.model.dto.UserDto;

public interface UserOperations {

  @GetMapping(value = "/users")
  @ResponseStatus(value = HttpStatus.OK) // if you do not mention it, default OK
  ApiResponse<List<UserDto>> getAll();

  @GetMapping(value = "/user/{id}")
  ResponseEntity<ApiResponse<UserDto>> getById(@PathVariable(value = "id") Long id);

}
