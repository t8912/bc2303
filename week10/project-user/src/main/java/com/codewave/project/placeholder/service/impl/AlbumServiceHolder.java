//package com.codewave.project.placeholder.service.impl;

//public class AlbumServiceHolder {
  
//}

/*
 * package com.codewave.project.placeholder.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codewave.project.placeholder.model.dto.placeholder.PlaceHolderAlbumDto;
import com.codewave.project.placeholder.service.AlbumService;

@Service
public class AlbumServiceHolder implements AlbumService {

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  @Qualifier(value = "albumUrl")
  String albumUrl;

  @Override
  public List<PlaceHolderAlbumDto> getAll() {
    return Arrays.asList(restTemplate.getForObject(albumUrl, PlaceHolderAlbumDto[].class));
  }

  @Override
  public List<PlaceHolderAlbumDto> getByUserId(Long userId) {
    return Arrays.asList(restTemplate.getForObject(albumUrl + "?userId=" + userId, PlaceHolderAlbumDto[].class));
  }

  @Override
  public PlaceHolderAlbumDto getById(Long id) {
    return this.getAll().stream()
        .filter(e -> e.getId() == id)
        .findFirst()
        .orElse(null);
  }

}

 */
