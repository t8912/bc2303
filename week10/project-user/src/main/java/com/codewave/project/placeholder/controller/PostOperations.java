package com.codewave.project.placeholder.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codewave.project.placeholder.infra.response.ApiResponse;
import com.codewave.project.placeholder.model.dto.PostDto;

public interface PostOperations {

  @GetMapping(value = "/user/{id}/posts")
  ResponseEntity<ApiResponse<List<PostDto>>> getByUserId(@PathVariable(value = "id") Long id);

  // @PostMapping(value = "/user/{id}/post")
  // ResponseEntity<ApiResponse<PostDto>> createByUserId(@PathVariable(value = "id") Long id);

}

