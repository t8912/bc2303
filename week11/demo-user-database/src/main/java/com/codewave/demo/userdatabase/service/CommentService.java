package com.codewave.demo.userdatabase.service;

import java.util.List;
import java.util.Optional;

import com.codewave.demo.userdatabase.entity.Comment;
import com.codewave.demo.userdatabase.model.dto.placeholder.CommentDto;

public interface CommentService {
  
  List<CommentDto> getAllFromPlaceHolder();

  public List<Comment> getAllByPostId(Long postId);

  List<Comment> getAll();

  Optional<Comment> get(Long id);

  Comment addByPostId(Comment comment, Long postId);

  int remove(Long id);

  Comment update(Comment comment, Long postId);

  List<Comment> addOrUpdateAll(List<Comment> comments);

}