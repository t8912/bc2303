package com.codewave.project.placeholder.service;

import java.util.List;

import com.codewave.project.placeholder.model.dto.placeholder.PlaceHolderUserDto;

public interface UserService {

  List<PlaceHolderUserDto> getAll();

  PlaceHolderUserDto getById(Long id);

}
