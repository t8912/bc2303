package com.codewave.demo.userdatabase.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.demo.userdatabase.controller.CommentOperation;
import com.codewave.demo.userdatabase.entity.Comment;
import com.codewave.demo.userdatabase.infra.response.ApiResponse;
import com.codewave.demo.userdatabase.model.dto.request.CommentReqDto;
import com.codewave.demo.userdatabase.model.dto.response.CommentRespDto;
import com.codewave.demo.userdatabase.service.CommentService;

@RestController
@RequestMapping(value = "/data/v1")
public class CommentController implements CommentOperation {

  @Autowired
  CommentService commentService;

  @Autowired
  ModelMapper modelMapper;

  @Override
  public ApiResponse<List<CommentRespDto>> getAllByPostId(Long postId) {
    // System.out.println("yes");
    List<CommentRespDto> commentRespDtos = commentService.getAllByPostId(postId)
        .stream()
        .map(e -> modelMapper.map(e, CommentRespDto.class))
        .collect(Collectors.toList());
    return ApiResponse.<List<CommentRespDto>>builder()
        .ok()
        .data(commentRespDtos) // revise to call DB
        .build();
  }

  @Override
  public ApiResponse<CommentRespDto> get(Long id) {
    CommentRespDto commentRespDto = modelMapper.map(commentService.get(id).orElse(new Comment()), CommentRespDto.class);
    return ApiResponse.<CommentRespDto>builder()
        .ok()
        .data(commentRespDto) // revise to call DB
        .build();
  }

  @Override
  public ApiResponse<CommentRespDto> addByPostId(CommentReqDto commentReqDto, Long postId) {
    Comment comment = modelMapper.map(commentReqDto, Comment.class);
    Comment result = commentService.addByPostId(comment, postId);
    CommentRespDto commentRespDto = null;
    if (result != null) {
      commentRespDto = modelMapper.map(result, CommentRespDto.class);
    }
    return ApiResponse.<CommentRespDto>builder()
        .ok()
        .data(commentRespDto) // revise to call DB
        .build();
  }

  @Override
  public ApiResponse<Integer> remove(Long id) {
    return ApiResponse.<Integer>builder()
        .ok()
        .data(commentService.remove(id)) // revise to call DB
        .build();
  }

  @Override
  public ApiResponse<CommentRespDto> update(CommentReqDto commentReqDto, Long id) {
    Comment comment = modelMapper.map(commentReqDto, Comment.class);
    CommentRespDto postRespDto = modelMapper.map(commentService.update(comment, id), CommentRespDto.class);
    return ApiResponse.<CommentRespDto>builder()
        .ok()
        .data(postRespDto) // revise to call DB
        .build();
  }

}
