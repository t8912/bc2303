package com.codewave.demo.postgresql.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.demo.postgresql.mapper.UserMapper;
import com.codewave.demo.postgresql.model.dto.request.UserRequestDto;
import com.codewave.demo.postgresql.model.dto.response.UserRespDto;

@RestController
@RequestMapping(value = "/mybatis/v1")
public class UserBatisController {

  @Autowired
  UserMapper userMapper;

  @GetMapping(value = "/users")
  public List<UserRespDto> getAll() {
    return userMapper.getAll().stream()
        .collect(Collectors.toList());
  }

  @PostMapping(value = "/user")
  public void createUser(@RequestBody UserRequestDto userRequestDto) {
    userMapper.insert(userRequestDto);
  }

  @DeleteMapping(value = "/user/{username}")
  public void deleteUser(@PathVariable(value = "username") String userName) {
    // System.out.println(userName);
    userMapper.delete(userName);
  }

  @PatchMapping(value = "/user/{id}/email/{email}")
  public void updateUserEmail(@PathVariable(value = "id") Long id, @PathVariable(value = "email") String email) {
    userMapper.update(email, id);
  }

  @GetMapping(value = "/user/posts")
  public Map<Truple, List<UserPostDto>> getAllUserPost() {
    return userMapper.getAllUserPost().stream()
    .collect(Collectors.groupingBy(post -> new Truple(post.getUserId())));
  }

  @GetMapping(value = "/user/posts2")
  public List<UserPostDto>> getAllUserPost2() {
    List<UserPostRespDto> result = new ArrayList<>();
    Long userId = -1L;
    List<PostRespDto> postRespDtos = new ArrayList<>();
    List<
    for (User userPostDto e: userMapper.getAllUserPost()) {
      if (e.hetUserId() != userId)
      userId = e.getUserId();
      postRespDto = new ArrayList<>();
    }
    postRespDtos.add(new PostRespDto(e.getPostId(), e.getPostId()));
  }
    return result;
  }
  


// added getById
  @GetMapping(value = "/user/{id}")
  public UserRespDto getById(@PathVariable(value = "id") Long id) {
    return userMapper.getById(id);
  }

}
