package com.codewave.demo.userdatabase.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.codewave.demo.userdatabase.infra.response.ApiResponse;
import com.codewave.demo.userdatabase.model.dto.PostDto;
import com.codewave.demo.userdatabase.model.request.PostReqDto;
import com.codewave.demo.userdatabase.model.response.PostRespDto;


public interface PostOperation {
  @GetMapping("/posts1")
  ResponseEntity<ApiResponse<List<PostDto>>> getAll();

  @GetMapping("/posts2/{id}")
  ResponseEntity<ApiResponse<PostDto>> getById(@PathVariable("id") Long id);

  @PostMapping("/posts3")
  ResponseEntity<ApiResponse<PostRespDto>> create(@RequestBody PostReqDto postReqDto);

  @PutMapping("/posts4/{id}")
  ResponseEntity<ApiResponse<PostRespDto>> update(@PathVariable("id") Long id, @RequestBody PostReqDto postReqDto);

  @DeleteMapping("/posts5/{id}")
  ResponseEntity<ApiResponse<Void>> delete(@PathVariable("id") Long id);
}

/* 

public interface PostOperation {

  @GetMapping(value = "/users/{id}/posts")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<PostDto>> findAllById(@PathVariable(value = "id") Long id);

  @PostMapping(value = "/users/{id}/posts")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<PostDto> saveByUserId(@PathVariable(value = "id") Long id, @RequestBody PostReqDto post);

  @PostMapping(value = "/posts")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<PostDto> save(@RequestBody PostReqDto post);

  @PutMapping(value = "/posts/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<PostDto> update(@PathVariable("id") Long id, @RequestBody PostReqDto post);

  @DeleteMapping(value = "/posts/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<Void> delete(@PathVariable("id") Long id);

}
*/





  /* 
  @GetMapping(value = "/user/{id}/posts")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<PostDto>> findAllById(@PathVariable(value = "id") Long id);

  // @GetMapping(value = "/user/{id}/post")
  // @ResponseStatus(value = HttpStatus.OK)
  // ApiResponse<List<PostDto>> saveByUserId(@PathVariable(value = "id") Long id);
  // @RequestBody // Please add code
  
  @GetMapping(value = "/user/{id}/post")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<PostDto>> saveByUserId(@PathVariable(value = "id") Long id, @RequestBody PostReqDto post);




  ////////////////////////////////

  


  // @GetMapping(value = "/user/hello")
  // @ResponseStatus(value = HttpStatus.OK)
  // ApiResponse<String> greeting();

}
*/
