package com.codewave.demo.postgresql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.codewave.demo.postgresql.mapper.UserMapper;

@RestController
@RequestMapping(value = "/mybatis/v1")
public class PostBatisController {

  @Autowired
  UserMapper userMapper;

  @GetMapping(value = "/user")
  public void creatUser(@RequestBody PostReqDto postReqDto) {
    
  }
  
}
