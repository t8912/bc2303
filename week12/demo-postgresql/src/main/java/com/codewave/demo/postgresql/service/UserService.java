package com.codewave.demo.postgresql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewave.demo.postgresql.entity.User;
import com.codewave.demo.postgresql.mapper.UserMapper;
import com.codewave.demo.postgresql.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  UserMapper userMapper;

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public List<User> getAllUserPost() {
    return userMapper.getAllUserPost();
  }


}
