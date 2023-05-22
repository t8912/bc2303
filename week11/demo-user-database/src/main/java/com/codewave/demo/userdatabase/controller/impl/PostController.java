package com.codewave.demo.userdatabase.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.demo.userdatabase.controller.PostOperation;
import com.codewave.demo.userdatabase.entity.Post;
import com.codewave.demo.userdatabase.infra.response.ApiResponse;
import com.codewave.demo.userdatabase.model.dto.request.PostReqDto;
import com.codewave.demo.userdatabase.model.dto.response.PostRespDto;
import com.codewave.demo.userdatabase.service.PostService;

@RestController
@RequestMapping(value = "/data/v1")
public class PostController implements PostOperation {

  @Autowired
  PostService postService;

  @Autowired
  ModelMapper modelMapper;

  @Override
  public ApiResponse<List<PostRespDto>> getAllByUserId(Long userId) {
    List<PostRespDto> postRespDtos = postService.getAllByUserId(userId)
        .stream()
        .map(e -> modelMapper.map(e, PostRespDto.class))
        .collect(Collectors.toList());
    return ApiResponse.<List<PostRespDto>>builder()
        .ok()
        .data(postRespDtos) // revise to call DB
        .build();
  }

  @Override
  public ApiResponse<List<PostRespDto>> getAll() {
    List<PostRespDto> postRespDtos = postService.getAll()
        .stream()
        .map(e -> modelMapper.map(e, PostRespDto.class))
        .collect(Collectors.toList());
    return ApiResponse.<List<PostRespDto>>builder()
        .ok()
        .data(postRespDtos) // revise to call DB
        .build();
  }

  @Override
  public ApiResponse<PostRespDto> get(Long id) {
    PostRespDto postRespDto = modelMapper.map(postService.get(id).orElse(new Post()), PostRespDto.class);
    return ApiResponse.<PostRespDto>builder()
        .ok()
        .data(postRespDto) // revise to call DB
        .build();
  }

  @Override
  public ApiResponse<Integer> remove(Long id) {
    // postService.remove(id);
    return ApiResponse.<Integer>builder()
        .ok()
        .data(postService.remove(id)) // revise to call DB
        .build();
  }

  @Override
  public ApiResponse<PostRespDto> update(PostReqDto postReqDto, Long userId) {
    Post post = modelMapper.map(postReqDto, Post.class);
    Post result = postService.update(post, userId); // service layer to throw exception
    if (result != null) {
      PostRespDto postRespDto = modelMapper.map(result, PostRespDto.class);
      return ApiResponse.<PostRespDto>builder()
          .ok()
          .data(postRespDto) // revise to call DB
          .build();
    }
    return null;
  }

  @Override
  public ApiResponse<PostRespDto> addByUserId(PostReqDto postReqDto, Long userId) {
    Post post = modelMapper.map(postReqDto, Post.class);
    //System.out.println();
    Post result = postService.addByUserId(post, userId); // service layer to throw exception
    PostRespDto postRespDto = null;
    if (result != null) {
      postRespDto = modelMapper.map(result, PostRespDto.class);
    }
    return ApiResponse.<PostRespDto>builder()
        .ok()
        .data(postRespDto)
        .build();
  }

}
