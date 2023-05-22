package com.codewave.demo.userdatabase.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.mapping.Parameter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codewave.demo.userdatabase.entity.User;
import com.codewave.demo.userdatabase.infra.response.ApiResponse;
import com.codewave.demo.userdatabase.infra.util.ApiUtil;
import com.codewave.demo.userdatabase.infra.util.UriScheme;
import com.codewave.demo.userdatabase.model.dto.UserDto;
import com.codewave.demo.userdatabase.model.request.UserReqDto;
import com.codewave.demo.userdatabase.repository.UserRepository;
import com.codewave.demo.userdatabase.service.UserService;

import lombok.extern.slf4j.Slf4j;

/* 
@Service
@Slf4j
public class UserServiceHolder implements UserService {

  @Autowired
  RestTemplate restTemplate;
 
  @Value(value = "${api.project-user.domain}")
  String domain;

  @Value(value = "${api.project-user.port}")
  int port;

  @Value(value = "${api.project-user.base-path}")
  String basePath;

  @Value(value = "${api.project-user.version}")
  String version;

  @Value(value = "${api.project-user.endpoints.user}")
  String userEndpoint;

  @Autowired
  UserRepository userRepository;

  @Override
  public List<UserDto> getAll() {
    List<String> segments = new ArrayList<>();
    segments.add(basePath);
    segments.add(version);
    String url = ApiUtil.getUrl(UriScheme.HTTP, domain, port, segments, userEndpoint);
    log.info("getAll url={}", url);

    ResponseEntity<ApiResponse<List<UserDto>>> response = restTemplate.exchange(
        url,
        HttpMethod.GET,
        HttpEntity.EMPTY,
        new ParameterizedTypeReference<ApiResponse<List<UserDto>>>() {}
    );

    ApiResponse<List<UserDto>> apiResponse = response.getBody();
    if (apiResponse != null) {
      return (List<UserDto>) apiResponse.getData();
    }
    return Collections.emptyList();
  }

  @Override
  public List<User> getAllFromDb() {
    return userRepository.findAll();
  }

  @Override
  public User save(User user) {
    User newUser = new User();
    newUser.setFullName(user.getFullName());
    newUser.setUserName(user.getUserName());
    newUser.setUserEmail(user.getUserEmail());
    newUser.setUserPhone(user.getUserPhone());
    newUser.setUserWebsite(user.getUserWebsite());

    return userRepository.save(newUser);
  }

  @Override
  public User deleteById(Long id) {
    userRepository.deleteById(id);
    return null;
  }

  @Override
  public void deleteAllByIdInBatch(List<Long> ids) {
    userRepository.deleteAllByIdInBatch(ids);
  }

  @Override
  public List<User> saveAll(List<User> users) {
    return userRepository.saveAll(users);
  }

}



/* 
@Service
@Slf4j
public class UserServiceHolder implements UserService {

  @Autowired
  RestTemplate restTemplate;
 
  @Value(value = "${api.project-user.domain}")
  String domain;

  @Value(value = "${api.project-user.port}")
  int port;

  @Value(value = "${api.project-user.base-path}")
  String basePath;

  @Value(value = "${api.project-user.version}")
  String version;

  @Value(value = "${api.project-user.endpoints.user}")
  String userEndpoint;

  @Autowired
  UserRepository userRepository;

  @Override
  public List<UserDto> getAll() {
    List<String> segments = new ArrayList<>();
    segments.add(basePath);
    segments.add(version);
    String url = ApiUtil.getUrl(UriScheme.HTTP, domain, port, segments, userEndpoint);
    log.info("getAll url={}", url);

    ResponseEntity<ApiResponse<List<UserDto>>> response = restTemplate.exchange(
        url,
        HttpMethod.GET,
        HttpEntity.EMPTY,
        new ParameterizedTypeReference<ApiResponse<List<UserDto>>>() {}
    );

    ApiResponse<List<UserDto>> apiResponse = response.getBody();
    if (apiResponse != null) {
      return apiResponse.getData();
    }
    return Collections.emptyList();
  }

  @Override
  public List<User> getAllFromDb() {
    return userRepository.findAll();
  }

  @Override
  public User save(UserReqDto user) {
    User newUser = new User();
    newUser.setFullName(user.getFullName());
    newUser.setUserName(user.getUserName());
    newUser.setUserEmail(user.getUserEmail());
    newUser.setUserPhone(user.getUserPhone());
    newUser.setUserWebsite(user.getUserWebsite());

    return userRepository.save(newUser);
  }

  @Override
  public User deleteById(Long id) {
    userRepository.deleteById(id);
    return null;
  }

  @Override
  public void deleteAllByIdInBatch(List<Long> ids) {
    userRepository.deleteAllByIdInBatch(ids);
  }

  @Override
  public List<User> saveAll(List<User> users) {
    return userRepository.saveAll(users);
  }

}
*/



@Service
@Slf4j
public class UserServiceHolder implements UserService {

  @Autowired
  RestTemplate restTemplate;
 
  @Value(value = "${api.project-user.domain}")
  String domain;

  @Value(value = "${api.project-user.port}")
  int port;

  @Value(value = "${api.project-user.base-path}")
  String basePath;

  @Value(value = "${api.project-user.version}")
  String version;

  @Value(value = "${api.project-user.endpoints.user}")
  String userEndpoint;

  @Autowired
  UserRepository userRepository;

  @Override
  public List<UserDto> getAll() {
    List<String> segments = new ArrayList<>();
    segments.add(basePath);
    segments.add(version);
    String url = ApiUtil.getUrl(UriScheme.HTTP, domain, port, segments, userEndpoint);
    // String url = "http://localhost:8091/placeholder/v1/users";
    log.info("getAll url={}", url);

    //ApiResponse<List<UserDto>> obj = restTemplate.getForObject(url, ApiResponse.class);
    ResponseEntity<ApiResponse<List<UserDto>>> obj  = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
    new ParameterizedTypeReference<ApiResponse<List<UserDto>>>() {
    });
    ApiResponse<List<UserDto>> body = obj.getBody();
    //return

    if (obj != null) { // null check
      return body.getData(); // OK
    }
    return new ArrayList<>();
  }

  @Override
  public List<User> getAllFromDb() {
    return userRepository.findAll();
  }

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public void deleteAllByIdInBatch(List<Long> ids){
  userRepository.deleteAllByIdInBatch(ids); // Please fix this line coding
  }

  @Override
  public List<User> saveAll(List<User> users){
  return userRepository.saveAllAndFlush(users);
  }

  @Override
  public User deleteById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
  }
  


}
