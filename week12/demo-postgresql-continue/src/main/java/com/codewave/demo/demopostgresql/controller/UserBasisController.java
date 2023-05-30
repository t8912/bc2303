package com.codewave.demo.demopostgresql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.demo.demopostgresql.mapper.UserMapper;
import com.codewave.demo.demopostgresql.service.UserService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/postgres/v1")
public class UserBasisController {
    @Autowired
    UserService userService;
  
  
    @GetMapping(value = "/users")
    public List<UserRespDto> getAll() {
      return userService.getAll().stream()
          .collect(Collectors.toList());
    }

@PostMapping(value = "/user")
public void createUser(@RequestBody UserRequestDto userRequestDto) {
  userMapper.insert(userRequestDto);
}

@DeleteMapping(value = "/user/{username}")
public void deleteUser(@PathVariable(value = "username") String userName) {
  userMapper.delete(userName);
}

@PatchMapping(value = "/user/{id}/email/{email}")
public void updateUserEmail(@PathVariable(value = "id") Long id, @PathVariable(value = "email") String email) {
  UserMapper.update(email, id);
}

}


