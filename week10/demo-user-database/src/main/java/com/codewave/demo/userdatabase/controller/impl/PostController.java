package com.codewave.demo.userdatabase.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.demo.userdatabase.controller.PostOperation;
import com.codewave.demo.userdatabase.entity.Post;
import com.codewave.demo.userdatabase.entity.User;
import com.codewave.demo.userdatabase.infra.response.ApiResponse;
import com.codewave.demo.userdatabase.model.dto.PostDto;
import com.codewave.demo.userdatabase.model.dto.UserDto;
import com.codewave.demo.userdatabase.model.request.PostReqDto;
import com.codewave.demo.userdatabase.model.response.PostRespDto;
import com.codewave.demo.userdatabase.service.PostService;

//@RestController
//@RequestMapping(value = "/data/v1")
//public class PostController implements PostOperation {

  @RestController
@RequestMapping(value = "/data/v1")
public class PostController implements PostOperation {
    @Autowired
    private PostService postService;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public ResponseEntity<ApiResponse<List<PostDto>>> getAll() {
        List<PostDto> posts = postService.getAll();
        ApiResponse<List<PostDto>> response = ApiResponse.<List<PostDto>>builder()
                .ok()
                .data(posts)
                .build();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse<PostDto>> getById(@PathVariable("id") Long id) {
        PostDto post = postService.getById(id);
        ApiResponse<PostDto> response = ApiResponse.<PostDto>builder()
                .ok()
                .data(post)
                .build();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse<PostRespDto>> create(@RequestBody PostReqDto postReqDto) {
        PostDto createdPost = postService.create(postReqDto);
        PostRespDto postRespDto = modelMapper.map(createdPost, PostRespDto.class);
        ApiResponse<PostRespDto> response = ApiResponse.<PostRespDto>builder()
                .ok()
                .data(postRespDto)
                .build();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse<PostRespDto>> update(@PathVariable("id") Long id, @RequestBody PostReqDto postReqDto) {
        PostDto updatedPost = postService.update(id, postReqDto);
        PostRespDto postRespDto = modelMapper.map(updatedPost, PostRespDto.class);
        ApiResponse<PostRespDto> response = ApiResponse.<PostRespDto>builder()
                .ok()
                .data(postRespDto)
                .build();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable("id") Long id) {
        postService.delete(id);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .ok()
                .build();
        return ResponseEntity.ok(response);
    }
}




  /* 
  // PostController.java
@RestController
@RequestMapping(value = "/data/v1")
public class PostController implements PostOperation {

  @Autowired
  PostService postService;

  @Override
  public ApiResponse<List<PostDto>> findAllById(Long id) {
    return ApiResponse.<List<PostDto>>builder()
        .ok()
        .data(postService.findAllById(id))
        .build();
  }

  @Override
  public ApiResponse<PostDto> saveByUserId(Long id, PostReqDto post) {
    PostDto savedPost = postService.saveByUserId(id, post);
    return ApiResponse.<PostDto>builder()
        .ok()
        .data(savedPost)
        .build();
  }

  @Override
  public ApiResponse<PostDto> save(PostReqDto post) {
    PostDto savedPost = postService.save(post);
    return ApiResponse.<PostDto>builder()
        .ok()
        .data(savedPost)
        .build();
  }

  @Override
  public ApiResponse<PostDto> update(Long id, PostReqDto post) {
    PostDto updatedPost = postService.update(id, post);
    return ApiResponse.<PostDto>builder()
        .ok()
        .data(updatedPost)
        .build();
  }

  @Override
  public ApiResponse<Void> delete(Long id) {
    postService.delete(id);
    return ApiResponse.<Void>builder()
        .ok()
        .build();
  }

}

*/

/*
 

  @Autowired
  PostService postService;
  
  @Override
  public ApiResponse<List<PostDto>> findAllById(Long id) {
    return ApiResponse.<List<PostDto>>builder()
        .ok()
        .data(postService.findAllById(id)) // revise to call DB
        .build();
  }



/////////



}
  // @Override
  // public ApiResponse<String> greeting() {
  //   return ApiResponse.<String>builder()
  //       .ok()
  //       .data("hello")
  //       .build();
  // }
//}

*/
