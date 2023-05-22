package com.codewave.demo.userdatabase.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codewave.demo.userdatabase.entity.User;
import com.codewave.demo.userdatabase.infra.response.ApiResponse;
import com.codewave.demo.userdatabase.infra.util.ApiUtil;
import com.codewave.demo.userdatabase.infra.util.UriScheme;
import com.codewave.demo.userdatabase.model.dto.placeholder.UserDto;
import com.codewave.demo.userdatabase.repository.UserRepository;
import com.codewave.demo.userdatabase.service.UserService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

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
  public List<UserDto> getAllFromPlaceHolder() {
    List<String> segments = new ArrayList<>();
    segments.add(basePath);
    segments.add(version);
    String url = ApiUtil.getUrl(UriScheme.HTTP, domain, port, segments, userEndpoint);
    // String url = "http://localhost:8091/placeholder/v1/users";
    log.info("getAll url={}", url);

    ResponseEntity<ApiResponse<List<UserDto>>> obj = restTemplate.exchange(url,
        HttpMethod.GET, HttpEntity.EMPTY,
        new ParameterizedTypeReference<ApiResponse<List<UserDto>>>() {
        });
    ApiResponse<List<UserDto>> body = obj.getBody();
    return body != null ? body.getData() : new ArrayList<>();
  }

  @Override
  public List<User> getAll() {
    return userRepository.findAll();
  }

  @Override
  public User getByUserName(String userName) {
    if (userName != null & !"".equals(userName))
      return userRepository.findByUserName(userName);
    return null;
  }

  @Override
  public Optional<User> get(Long id) {
    if (id != null)
      return userRepository.findById(id);
    return null;
  }

  @Override
  public User add(User user) {
    if (user != null && !"".equals(user.getUserName()) //
        && !userRepository.existsByUserName(user.getUserName())) {
      return userRepository.save(user);
    }
    return null;
  }

  @Override
  @Transactional
  public int remove(Long id) { // TBC, handle runtime exception
    return userRepository.deleteByIdReturnCount(id);
  }

  @Override
  public User update(User newUser, Long id) { // handle runtime exception
    if (id == null || newUser == null)
      return null;

    return userRepository.findById(id)
        .map(user -> {
          user.setFullName(newUser.getFullName());
          user.setEmail(newUser.getEmail());
          user.setPhone(newUser.getPhone());
          user.setWebsite(newUser.getWebsite());
          // user.setUserName(newUser.getUserName());
          return userRepository.save(user);
        }).orElseGet(() -> {
          return null;
        });
  }

  @Override
  public void removeAll(List<Long> ids) {
    if (ids != null && ids.size() > 0)
      userRepository.deleteAllByIdInBatch(ids);
  }
  
  @Override
  public void removeAll() {
    userRepository.deleteAll();
  }

  @Override
  public List<User> addOrUpdateAll(List<User> users) {
    if (users != null && users.size() != 0)
      return userRepository.saveAll(users);
    return new ArrayList<>();
  }
}
