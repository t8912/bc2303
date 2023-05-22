package com.codewave.demo.userdatabase.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.codewave.demo.userdatabase.infra.response.ApiResponse;
import com.codewave.demo.userdatabase.model.dto.request.UserReqDto;
import com.codewave.demo.userdatabase.model.dto.response.UserRespDto;

public interface UserOperation {

  @GetMapping(value = "/users")
  ApiResponse<List<UserRespDto>> getAll();

  @GetMapping(value = "/user/{id}")
  ApiResponse<UserRespDto> get(@PathVariable(value = "id") Long id);

  @GetMapping(value = "/user/username/{userName}")
  ApiResponse<UserRespDto> getByUserName(@PathVariable(value = "userName") String userName);

  @PostMapping(value = "/user")
  ApiResponse<UserRespDto> add(@RequestBody UserReqDto userReqDto);

  @DeleteMapping(value = "/user/{id}")
  ApiResponse<Integer> remove(@PathVariable(value = "id") Long id);

  @PutMapping(value = "/user/{id}")
  ApiResponse<UserRespDto> update(@RequestBody UserReqDto userReqDto, //
      @PathVariable(value = "id") Long id);

}
