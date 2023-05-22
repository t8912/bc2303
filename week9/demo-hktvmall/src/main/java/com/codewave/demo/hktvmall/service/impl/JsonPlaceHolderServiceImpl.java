package com.codewave.demo.hktvmall.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.codewave.demo.hktvmall.service.JsonPlaceHolderService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JsonPlaceHolderServiceImpl implements JsonPlaceHolderService {
  
  @Value(value = "${api.jsonplaceholder.domain}")
  String userDomain;

  @Value(value = "${api.jsonplaceholder.endpoint}")
  String userEndpoint;

  @Override
  public List<User> getAllUsers() {
    //log.info("start getAllUsers");
    //log.info("userDomain={}, userEndpoint={}", userDomain, userEndpoint);
    //RestTemplate restTemplate = new RestTemplate();

   String url = UriComponentsBuilder.newInstance()
   .scheme("https")
   .host(userDomain)
   .path(userEndpoint)
   .toUriString();


   return Arrays.asList(restTemplate.getForObject(url, User[].class));
   //log.info(url);

    //return new ArrayList<>();

    //return users;

  }
  
}
