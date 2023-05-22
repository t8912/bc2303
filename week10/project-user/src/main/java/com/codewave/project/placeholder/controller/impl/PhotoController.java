//package com.codewave.project.placeholder.controller.impl;

//import com.codewave.project.placeholder.controller.PhotoOperations;

//public class PhotoController implements PhotoOperations {
  
  
//}

/*
 * package com.codewave.project.placeholder.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.project.placeholder.controller.PhotoOperations;
import com.codewave.project.placeholder.infra.response.ApiResponse;
import com.codewave.project.placeholder.model.PhotoDto;
import com.codewave.project.placeholder.service.PhotoService;

@RestController
@RequestMapping(value = "/placeholder/v1")
public class PhotoController implements PhotoOperations {

  @Autowired
  PhotoService photoService;

  @Autowired
  ModelMapper modelMapper;

  @Override
  public ResponseEntity<ApiResponse<List<PhotoDto>>> getAll() {
    List<PhotoDto> photos = photoService.getAll().stream()
        .map(e -> modelMapper.map(e, PhotoDto.class))
        .collect(Collectors.toList());
    ApiResponse<List<PhotoDto>> response = ApiResponse.<List<PhotoDto>>builder()
        .ok()
        .data(photos)
        .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<PhotoDto>> getById(Long id) {
    PhotoDto photo = modelMapper.map(photoService.getById(id), PhotoDto.class);
    ApiResponse<PhotoDto> response = ApiResponse.<PhotoDto>builder()
        .ok()
        .data(photo)
        .build();
    return ResponseEntity.ok().body(response);
  }

}


 */
