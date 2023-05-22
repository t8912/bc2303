package com.codewave.demo.hktvmall.service;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;


public interface JsonPlaceHolderService {

  List<User> getAllUsers();
  
}
