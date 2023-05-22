package com.codewave.demo.userdatabase.service;

import java.util.List;
import java.util.Optional;

import com.codewave.demo.userdatabase.entity.User;
import com.codewave.demo.userdatabase.model.dto.placeholder.UserDto;

public interface UserService {
  /**
   * For ScheduledTask Use (Invoke JsonPlaceHolder)
   * 
   * @param id
   * @return
   */
  List<UserDto> getAllFromPlaceHolder();

  List<User> getAll();

  Optional<User> get(Long id);

  User getByUserName(String userName);

  User add(User user);

  int remove(Long id);

  User update(User user, Long userId);

  List<User> addOrUpdateAll(List<User> users);

  void removeAll(List<Long> ids);

  void removeAll();

}
