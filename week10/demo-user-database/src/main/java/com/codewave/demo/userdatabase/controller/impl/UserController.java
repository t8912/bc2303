package com.codewave.demo.userdatabase.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.demo.userdatabase.controller.UserOperation;
import com.codewave.demo.userdatabase.entity.User;
import com.codewave.demo.userdatabase.infra.response.ApiResponse;
import com.codewave.demo.userdatabase.model.dto.UserDto;
import com.codewave.demo.userdatabase.model.request.UserReqDto;
import com.codewave.demo.userdatabase.model.response.UserRespDto;
import com.codewave.demo.userdatabase.service.UserService;

@RestController
@RequestMapping(value = "/data/v1")
public class UserController implements UserOperation {


  @Autowired
  UserService userService;

  @Autowired
  ModelMapper modelMapper;

  //private UserRespDto userRespDto;

  //private Object request;

  @Override
  public ApiResponse<List<UserDto>> findAll() {
    return ApiResponse.<List<UserDto>>builder()
        .ok()
        .data(userService.getAll()) // Revise to dcdall DB
        .build();
  }

  @Override
  public ApiResponse<UserRespDto> save(UserReqDto request) {
    System.out.println(request.toString());
    User user = modelMapper.map(request, User.class);
    UserRespDto userRespDto = modelMapper.map(userService.save(user), UserRespDto.class) ;
    return ApiResponse.<UserRespDto>builder()
        .ok()
        .data(userRespDto)
        .build();
  }

  @Override
  public ApiResponse<UserRespDto> update(Long id, UserReqDto user) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public ApiResponse<Void> delete(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public ApiResponse<UserRespDto> partialUpdate(Long id, UserReqDto user) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'partialUpdate'");
  }
}

