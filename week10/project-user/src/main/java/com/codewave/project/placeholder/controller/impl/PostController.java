package com.codewave.project.placeholder.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.project.placeholder.controller.PostOperations;
import com.codewave.project.placeholder.infra.response.ApiResponse;
import com.codewave.project.placeholder.model.dto.PostDto;
import com.codewave.project.placeholder.service.PostService;

@RestController
@RequestMapping(value = "/placeholder/v1")
public class PostController implements PostOperations {

  @Autowired
  PostService postService;

  @Autowired
  ModelMapper modelMapper;

  @Override
  public ResponseEntity<ApiResponse<List<PostDto>>> getByUserId(Long id) {
    List<PostDto> posts = postService.getByUserId(id).stream()
        .map(e -> modelMapper.map(e, PostDto.class))
        .collect(Collectors.toList());

    ApiResponse<List<PostDto>> response = ApiResponse.<List<PostDto>>builder()
        .ok()
        .data(posts)
        .build();
    return ResponseEntity.ok().body(response);
  }
}
