package com.codewave.project.placeholder.controller.impl;
/* 
 * import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codewave.project.placeholder.controller.AlbumOperations;
import com.codewave.project.placeholder.infra.response.ApiResponse;
import com.codewave.project.placeholder.model.AlbumDto;
import com.codewave.project.placeholder.service.AlbumService;

@RestController
@RequestMapping(value = "/placeholder/v1")
public class AlbumController implements AlbumOperations {

  @Autowired
  AlbumService albumService;

  @Autowired
  ModelMapper modelMapper;

  @Override
  public ResponseEntity<ApiResponse<List<AlbumDto>>> getAll() {
    List<AlbumDto> albums = albumService.getAll().stream()
        .map(e -> modelMapper.map(e, AlbumDto.class))
        .collect(Collectors.toList());
    ApiResponse<List<AlbumDto>> response = ApiResponse.<List<AlbumDto>>builder()
        .ok()
        .data(albums)
        .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<AlbumDto>> getById(Long id) {
    AlbumDto album = modelMapper.map(albumService.getById(id), AlbumDto.class);
    ApiResponse<AlbumDto> response = ApiResponse.<AlbumDto>builder()
        .ok()
        .data(album)
        .build();
    return ResponseEntity.ok().body(response);
  }
}
*/

