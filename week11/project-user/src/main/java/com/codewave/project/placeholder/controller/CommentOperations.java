package com.codewave.project.placeholder.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codewave.project.placeholder.infra.response.ApiResponse;
import com.codewave.project.placeholder.model.dto.CommentDto;

public interface CommentOperations {

  @GetMapping(value = "/post/{id}/comments")
  ResponseEntity<ApiResponse<List<CommentDto>>> getByPostId(@PathVariable(value = "id") Long postId);
  
  @GetMapping(value = "/comments")
  ResponseEntity<ApiResponse<List<CommentDto>>> getAll();

}
