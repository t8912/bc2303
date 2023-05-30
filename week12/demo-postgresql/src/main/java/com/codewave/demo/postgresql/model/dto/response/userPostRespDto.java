package com.codewave.demo.postgresql.model.dto.response;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class userPostRespDto {

  Long id;
  
  String userName;

  //List<PostRespDto> postRespDtos = new ArrayList<>();
  List<PostRespDto> postRespDtos;
  
}

