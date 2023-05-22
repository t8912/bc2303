package com.codewave.project.placeholder.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codewave.project.placeholder.model.dto.placeholder.PlaceHolderCommentDto;
import com.codewave.project.placeholder.service.CommentService;

@Service
public class CommentServiceHolder implements CommentService {

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  @Qualifier(value = "commentUrl")
  String commentUrl;

  @Override
  public List<PlaceHolderCommentDto> getAll() {
    return Arrays.asList(restTemplate.getForObject(commentUrl, PlaceHolderCommentDto[].class));
  }

  @Override
  public List<PlaceHolderCommentDto> getByPostId(Long id) {
    return this.getAll().stream()
        .filter(e -> e.getPostId() == id)
        .collect(Collectors.toList());
  }
}
