package com.codewave.demo.userdatabase.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//import com.codewave.demo.userdatabase.entity.User;
import com.codewave.demo.userdatabase.infra.response.ApiResponse;
import com.codewave.demo.userdatabase.model.dto.UserDto;
import com.codewave.demo.userdatabase.model.request.UserReqDto;
import com.codewave.demo.userdatabase.model.response.UserRespDto;

public interface UserOperation {

  @GetMapping(value = "/users")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<UserDto>> findAll();

  @PostMapping(value = "/user")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<UserRespDto> save(@RequestBody UserReqDto user);

//PutMapping

//DeleteMapping

//PatchMapping

@PutMapping(value = "/user/{id}")
@ResponseStatus(value = HttpStatus.OK)
ApiResponse<UserRespDto> update(@PathVariable("id") Long id, @RequestBody UserReqDto user);

@DeleteMapping(value = "/user/{id}")
@ResponseStatus(value = HttpStatus.OK)
ApiResponse<Void> delete(@PathVariable("id") Long id);

@PatchMapping(value = "/user/{id}")
@ResponseStatus(value = HttpStatus.OK)
ApiResponse<UserRespDto> partialUpdate(@PathVariable("id") Long id, @RequestBody UserReqDto user);

}

