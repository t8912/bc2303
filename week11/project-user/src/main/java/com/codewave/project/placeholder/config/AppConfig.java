package com.codewave.project.placeholder.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.codewave.project.placeholder.infra.util.ApiUtil;
import com.codewave.project.placeholder.infra.util.UriScheme;
import com.codewave.project.placeholder.model.dto.UserDto;
import com.codewave.project.placeholder.model.dto.placeholder.PlaceHolderUserDto;

@Configuration
public class AppConfig {

  @Value(value = "${api.jsonplaceholder.domain}")
  String domain;

  @Value(value = "${api.jsonplaceholder.user.endpoint}")
  String userEndpoint;

  @Value(value = "${api.jsonplaceholder.post.endpoint}")
  String postEndpoint;

  @Value(value = "${api.jsonplaceholder.comment.endpoint}")
  String commentEndpoint;

  @Bean
  public String userUrl() {
    return ApiUtil.getUrl(UriScheme.HTTPS, domain, userEndpoint);
  }

  @Bean
  public String postUrl() {
    return ApiUtil.getUrl(UriScheme.HTTPS, domain, postEndpoint);
  }

  @Bean
  public String commentUrl() {
    return ApiUtil.getUrl(UriScheme.HTTPS, domain, commentEndpoint);
  }

  @Bean // The returned Object will be placed into Spring Context
  ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean // The returned Object will be placed into Spring Context
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean // The returned Object will be placed into Spring Context
  // A kind of constructor injection
  List<UserDto> userList(RestTemplate restTemplate, String userUrl, ModelMapper modelMapper) {
    List<PlaceHolderUserDto> userDtos = Arrays.asList(restTemplate.getForObject(userUrl, PlaceHolderUserDto[].class));
    return userDtos.stream()
        .map(e -> modelMapper.map(e, UserDto.class))
        .collect(Collectors.toList());
  }

}
