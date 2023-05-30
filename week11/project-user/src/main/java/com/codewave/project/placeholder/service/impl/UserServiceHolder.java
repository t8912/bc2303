package com.codewave.project.placeholder.service.impl;

import java.lang.module.ResolutionException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codewave.project.placeholder.model.dto.placeholder.PlaceHolderUserDto;
import com.codewave.project.placeholder.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class UserServiceHolder implements UserService {

  @Autowired
  RestTemplate restTemplate;


  @Autowired
  @Qualifier(value = "userUrl")
  String userUrl;

  @Override
  public List<PlaceHolderUserDto> getAll() throws JsonProcessingException {
    try {
      PlaceHolderUserDto[] users = restTemplate.getForObject(userUrl, PlaceHolderUserDto[].class);
      redisService.setUsers(users);
      return Arrays.asList(users);
    } catch (ResolutionExceptione e) {
      //
     return Arrays.asList(redisService.getUSers());
    }
    
  }

  @Override
  public PlaceHolderUserDto getById(Long id) {
    return this.getAll().stream()
        .filter(e -> e.getId() == id) // 
        .findFirst()
        .orElse(null);
  }
}
