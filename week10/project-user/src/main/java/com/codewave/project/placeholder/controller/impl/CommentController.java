package com.codewave.project.placeholder.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.project.placeholder.controller.CommentOperations;
import com.codewave.project.placeholder.infra.response.ApiResponse;
import com.codewave.project.placeholder.model.dto.CommentDto;
import com.codewave.project.placeholder.service.CommentService;

@RestController
@RequestMapping(value = "/placeholder/v1")
public class CommentController implements CommentOperations {

  @Autowired
  CommentService commentService;

  @Autowired
  ModelMapper modelMapper;

  @Override
  public ResponseEntity<ApiResponse<List<CommentDto>>> getByUserId(Long id) {
    List<CommentDto> comments = commentService.getByPostId(id).stream()
        .map(e -> modelMapper.map(e, CommentDto.class))
        .collect(Collectors.toList());

    ApiResponse<List<CommentDto>> response = ApiResponse.<List<CommentDto>>builder()
        .ok()
        .data(comments)
        .build();
    return ResponseEntity.ok().body(response);
  }
}

 
