package com.codewave.project.placeholder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewave.project.placeholder.infra.util.RedisUtil;

@Service
public class TestRedisService {

  // @Autowired
  // TestRepository testRepository;

  @Autowired
  RedisUtil redisUtil;

  public void set(String key, String val) {
    redisUtil.set(key, val, 60000);
  }

  public String get(String key) {
    return redisUtil.get(key).toString(); 
  }

  // public String get(String key) {
  //   return testRepository.findById(key).orElse("");
  // }
  
}
