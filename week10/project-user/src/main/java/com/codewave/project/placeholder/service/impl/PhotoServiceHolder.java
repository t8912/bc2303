//package com.codewave.project.placeholder.service.impl;

//public class PhotoServiceHolder {
  
//}

/*
 * 
package com.codewave.project.placeholder.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codewave.project.placeholder.model.dto.placeholder.PlaceHolderPhotoDto;
import com.codewave.project.placeholder.service.PhotoService;

@Service
public class PhotoServiceHolder implements PhotoService {

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  @Qualifier(value = "photoUrl")
  String photoUrl;

  @Override
  public List<PlaceHolderPhotoDto> getAll() {
    return Arrays.asList(restTemplate.getForObject(photoUrl, PlaceHolderPhotoDto[].class));
  }

  @Override
  public PlaceHolderPhotoDto getById(Long id) {
    return this.getAll().stream()
        .filter(e -> e.getId() == id)
        .findFirst()
        .orElse(null);
  }

  @Override
  public List<PlaceHolderPhotoDto> getByAlbumId(Long albumId) {
    return this.getAll().stream()
        .filter(e -> e.getAlbumId() == albumId)
        .toList();
  }
}

 */
