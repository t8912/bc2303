package com.codewave.demo.userdatabase.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.codewave.demo.userdatabase.infra.response.ApiResponse;
import com.codewave.demo.userdatabase.model.dto.request.PostReqDto;
import com.codewave.demo.userdatabase.model.dto.response.PostRespDto;

public interface PostOperation {

  @GetMapping(value = "/posts")
  ApiResponse<List<PostRespDto>> getAll();

  @GetMapping(value = "/user/{id}/posts")
  ApiResponse<List<PostRespDto>> getAllByUserId(@PathVariable(value = "id") Long userId);

  @GetMapping(value = "/post/{id}")
  ApiResponse<PostRespDto> get(@PathVariable(value = "id") Long id);

  @PostMapping(value = "/user/{id}/post")
  ApiResponse<PostRespDto> addByUserId(@RequestBody PostReqDto postReqDto, //
      @PathVariable(value = "id") Long userId);

  @DeleteMapping(value = "/post/{id}")
  ApiResponse<Integer> remove(@PathVariable(value = "id") Long id);

  @PutMapping(value = "/post/{id}")
  ApiResponse<PostRespDto> update(@RequestBody PostReqDto postReqDto, //
      @PathVariable(value = "id") Long id);

}
