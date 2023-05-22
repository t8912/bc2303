package com.codewave.project.placeholder.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codewave.project.placeholder.model.dto.placeholder.PlaceHolderPostDto;
import com.codewave.project.placeholder.service.PostService;

@Service
public class PostServiceHolder implements PostService {

  @Autowired
  @Qualifier(value = "postUrl")
  String postUrl;

  @Autowired
  RestTemplate restTemplate;

  @Override
  public List<PlaceHolderPostDto> getAll() {
    return Arrays.asList(restTemplate.getForObject(postUrl, PlaceHolderPostDto[].class));
  }

  @Override
  public List<PlaceHolderPostDto> getByUserId(Long id) {
    return this.getAll().stream()
        .filter(e -> {
          // line of code
          return e.getUserId() == id;
        })
        .collect(Collectors.toList());
  }
}
