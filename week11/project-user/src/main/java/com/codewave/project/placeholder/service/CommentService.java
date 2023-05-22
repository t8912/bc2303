package com.codewave.project.placeholder.service;

import java.util.List;

import com.codewave.project.placeholder.model.dto.placeholder.PlaceHolderCommentDto;

public interface CommentService {

  List<PlaceHolderCommentDto> getAll();
  
  List<PlaceHolderCommentDto> getByPostId(Long postId);

}
