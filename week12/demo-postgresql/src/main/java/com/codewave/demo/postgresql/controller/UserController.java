package com.codewave.demo.postgresql.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.demo.postgresql.model.dto.response.UserRespDto;
import com.codewave.demo.postgresql.service.UserService;

@RestController
@RequestMapping(value = "/postgres/v1")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping(value = "/users")
  public List<UserRespDto> getAll() {
    return userService.findAll().stream()
        .map(e -> UserRespDto.builder()
            .id(e.getId())
            .fullName(e.getFullName())
            .userName(e.getUserName())
            .email(e.getEmail())
            .phone(e.getPhone())
            .website(e.getWebsite())
            .build())
        .collect(Collectors.toList());
  }
}
