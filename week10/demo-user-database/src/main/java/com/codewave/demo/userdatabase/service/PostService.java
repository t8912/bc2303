package com.codewave.demo.userdatabase.service;

import java.util.List;

import com.codewave.demo.userdatabase.entity.Post;
import com.codewave.demo.userdatabase.model.dto.PostDto;
import com.codewave.demo.userdatabase.model.request.PostReqDto;
import com.codewave.demo.userdatabase.model.response.PostRespDto;

public interface PostService {
  List<PostDto> getAll();

  PostDto getById(Long id);

  PostDto create(PostReqDto postReqDto);

  PostDto update(Long id, PostReqDto postReqDto);

  void delete(Long id);
}

  
  //List<PostDto> findAllById(Long id);
/* 
  List<Post> findAllById(Long id);

  Post save(Post post);

  void deleteById(Long id);

}
*/