package com.codewave.project.placeholder.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.project.placeholder.infra.response.ApiResponse;
import com.codewave.project.placeholder.service.impl.TestRedisService;


@RestController
@RequestMapping(value = "/redis/v1")
public class RedisContoller {

  @Autowired
  RedisService eedisService;

  // http://locahost:8091/redis/v1/test/19
  @GetMapping(value = "/test/key/{key}/value/{value}")
  public ApiResponse<Void> set(@PathVariable(value = "key") String key,
    @PathVariable(value = "value") String value) {
    testRedisService.set(key, value);
    return ApiResponse.<Void>builder()
    .ok()
    .data(null)
    .build();
  }
  
  @GetMapping(value = "/test/{key}")
  public ApiResponse<String> get(@PathVariable(value = "key") String key) {
    return ApiResponse.<String>builder()   
    .ok()
    .data(String).get(key))
    .build();
  }
  
}
