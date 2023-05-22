package com.codewave.demo.userdatabase.model.dto.response;

import com.codewave.demo.userdatabase.entity.Post;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRespDto {

  Long id;

  String name;
  
  String body;

  Post post;

}
