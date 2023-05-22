package com.codewave.project.placeholder.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.project.placeholder.controller.UserOperations;
import com.codewave.project.placeholder.infra.response.ApiResponse;
import com.codewave.project.placeholder.model.dto.UserDto;
import com.codewave.project.placeholder.service.UserService;

@RestController
@RequestMapping(value = "/placeholder/v1")
public class UserController implements UserOperations {

  @Autowired
  UserService userService;

  @Autowired
  ModelMapper modelMapper;

  @Override
  public ApiResponse<List<UserDto>> getAll() {
    List<UserDto> users = userService.getAll().stream()
        .map(e -> modelMapper.map(e, UserDto.class))
        .collect(Collectors.toList());
    return ApiResponse.<List<UserDto>>builder()
        .ok()
        .data(users)
        .build();
  }

  @Override
  public ResponseEntity<ApiResponse<UserDto>> getById(Long id) {
    UserDto user = modelMapper.map(userService.getById(id), UserDto.class);

    ApiResponse<UserDto> response = ApiResponse.<UserDto>builder()
        .ok()
        .data(user)
        .build();
    return ResponseEntity.ok().body(response);
  }

}
