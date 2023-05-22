package com.codewave.demo.userdatabase.service;

import java.util.List;
import java.util.Optional;

import com.codewave.demo.userdatabase.entity.Post;
import com.codewave.demo.userdatabase.model.dto.placeholder.PostDto;

public interface PostService {

  /**
   * For ScheduledTask Use (Invoke JsonPlaceHolder)
   * 
   * @param id
   * @return
   */
  List<PostDto> getAllFromPlaceHolder();

  List<Post> getAllByUserId(Long userId);

  List<Post> getAll();

  Optional<Post> get(Long id);

  Post addByUserId(Post post, Long userId);

  int remove(Long id);

  Post update(Post post, Long id);

  List<Post> addOrUpdateAll(List<Post> posts);

}
