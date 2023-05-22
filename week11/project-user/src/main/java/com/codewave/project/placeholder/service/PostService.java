package com.codewave.project.placeholder.service;

import java.util.List;

import com.codewave.project.placeholder.model.dto.placeholder.PlaceHolderPostDto;

public interface PostService {

  List<PlaceHolderPostDto> getAll();

  List<PlaceHolderPostDto> getByUserId(Long userId);

}
