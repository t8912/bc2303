package com.codewave.demo.userdatabase.service;

import java.util.List;

import com.codewave.demo.userdatabase.entity.User;
//import com.codewave.demo.userdatabase.entity.User;
import com.codewave.demo.userdatabase.model.dto.PostDto;
import com.codewave.demo.userdatabase.model.dto.UserDto;
//import com.codewave.demo.userdatabase.model.dto.UserDto;
import com.codewave.demo.userdatabase.model.request.PostReqDto;
import com.codewave.demo.userdatabase.model.request.UserReqDto;



  public interface UserService {

    List<UserDto> getAll();

  List<User> getAllFromDb();

  User save(User user);

  User deleteById(Long id);

  public void deleteAllByIdInBatch(List<Long> id);

  List<User> saveAll(List<User> users);

}

  /* 
    List<UserDto> getAll();
  
    List<User> getAllFromDb();
  
    User save(User user);
  
    User deleteById(Long id);
  
    void deleteAllByIdInBatch(List<Long> ids);
  
    List<User> saveAll(List<User> users);
  
  }
*/


  
  
