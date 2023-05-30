package com.codewave.project.placeholder.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewave.project.placeholder.infra.util.RedisUtil;
import com.codewave.project.placeholder.model.dto.placeholder.PlaceHolderUserDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RedisService {

  private final String userRedisKey = "project-user:place-holder:users";

  // @Autowired
  // TestRepository testRepository;

  // @Autowired
  // RedisUtil<List<PlaceHolderUserDto>> userRedisUtil;

  @Autowired
  RedisUtil<String> redisUtil;

  @Autowired
  ObjectMapper objectMapper;

  public void setUSers(PlaceHolderUserDto[] users) {
    redisUtil.set(userRedisKey, user, 120000);
  }

  public PlaceHolderUserDto[] getUsers() {
    try{

      String str = objectMapper.writeValueAsString(objectMapper)
    }
    Object obj = userRedisUtil.get(userRedisKey);
    if (obj instanceof Collection) {
      return (List<PlaceHolderUserDto>) userRedisUtil.get(userRedisKey);
    }
    return null;
  }





  public void setUsers(List<PlaceHolderUserDto> users) {
    redisUtil.set(userredisKey, users, 120000);
  }

  public List<PlaceHolderUserDto> getUsers() {
    Object obj = userRedisUtil.get(userRedisKey);
    if (obj instanceof Collection) {
      return (List<PlaceHolderUserDto>) userRedisUtil.get(userRedisKey);
    }
    return null;
  }

  public void set(String key, String value) {
    testRedisUtil.set(key, value, 120000);
  }

  public String get(String key) {
    return testRedisUtil.get(key); 
  }

  // public String get(String key) {
  //   return testRepository.findById(key).orElse("");
  // }
  
}
