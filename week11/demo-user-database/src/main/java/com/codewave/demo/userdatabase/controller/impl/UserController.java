package com.codewave.demo.userdatabase.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.demo.userdatabase.controller.UserOperation;
import com.codewave.demo.userdatabase.entity.User;
import com.codewave.demo.userdatabase.infra.response.ApiResponse;
import com.codewave.demo.userdatabase.model.dto.request.UserReqDto;
import com.codewave.demo.userdatabase.model.dto.response.UserRespDto;
import com.codewave.demo.userdatabase.service.UserService;

@RestController
@RequestMapping(value = "/data/v1")
public class UserController implements UserOperation {

  @Autowired
  UserService userService;

  @Autowired
  ModelMapper modelMapper;

  @Override
  public ApiResponse<List<UserRespDto>> getAll() {
    List<UserRespDto> userRespDtos = userService.getAll()
        .stream()
        .map(e -> modelMapper.map(e, UserRespDto.class))
        .collect(Collectors.toList());
    return ApiResponse.<List<UserRespDto>>builder()
        .ok()
        .data(userRespDtos) // Revise to call DB
        .build();
  }

  @Override
  public ApiResponse<UserRespDto> get(Long id) {
    // System.out.println(request.toString());
    UserRespDto userRespDto = modelMapper.map(userService.get(id), UserRespDto.class);
    return ApiResponse.<UserRespDto>builder()
        .ok()
        .data(userRespDto)
        .build();
  }

  @Override
  public ApiResponse<UserRespDto> getByUserName(String userName) {
    // System.out.println(request.toString());
    User result = userService.getByUserName(userName);
    UserRespDto userRespDto = null;
    if (result != null) {
      userRespDto = modelMapper.map(userService.getByUserName(userName), UserRespDto.class);
    }
    return ApiResponse.<UserRespDto>builder()
        .ok()
        .data(userRespDto)
        .build();
  }

  @Override
  public ApiResponse<UserRespDto> add(UserReqDto request) {
    User user = modelMapper.map(request, User.class);
    User result = userService.add(user);
    UserRespDto userRespDto = null;
    if (result != null) {
      userRespDto = modelMapper.map(result, UserRespDto.class);
    }
    return ApiResponse.<UserRespDto>builder()
        .ok()
        .data(userRespDto)
        .build();
  }

  @Override
  public ApiResponse<Integer> remove(Long id) {
    return ApiResponse.<Integer>builder()
        .ok()
        .data(userService.remove(id))
        .build();
  }

  @Override
  public ApiResponse<UserRespDto> update(UserReqDto request, Long id) {
    // userService.remove(id);
    User user = modelMapper.map(request, User.class);
    User result = userService.update(user, id);
    UserRespDto userRespDto = null;
    if (result != null) {
      userRespDto = modelMapper.map(result, UserRespDto.class);
    }
    return ApiResponse.<UserRespDto>builder()
        .ok()
        .data(userRespDto)
        .build();
  }

}
