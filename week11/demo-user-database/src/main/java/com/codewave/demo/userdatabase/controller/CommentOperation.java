package com.codewave.demo.userdatabase.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.codewave.demo.userdatabase.infra.response.ApiResponse;
import com.codewave.demo.userdatabase.model.dto.request.CommentReqDto;
import com.codewave.demo.userdatabase.model.dto.response.CommentRespDto;

public interface CommentOperation {

  // @GetMapping(value = "/posts")
  // List<Comment> getAll();

  @GetMapping(value = "/comment/{id}")
  ApiResponse<CommentRespDto> get(@PathVariable(value = "id") Long id);

  @GetMapping(value = "/post/{id}/comments")
  ApiResponse<List<CommentRespDto>> getAllByPostId(@PathVariable(value = "id") Long postId);

  @PostMapping(value = "/post/{id}/comment")
  ApiResponse<CommentRespDto> addByPostId(@RequestBody CommentReqDto commentReqDto,
      @PathVariable(value = "id") Long postId);

  @DeleteMapping(value = "/comment/{id}")
  ApiResponse<Integer> remove(@PathVariable(value = "id") Long id);

  @PutMapping(value = "/comment/{id}")
  ApiResponse<CommentRespDto> update(@RequestBody CommentReqDto commentReqDto, //
      @PathVariable(value = "id") Long id);

}
