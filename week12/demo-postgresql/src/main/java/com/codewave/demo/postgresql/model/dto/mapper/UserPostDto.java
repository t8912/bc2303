package com.codewave.demo.postgresql.model.dto.mapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPostDto {

  Long id;

  String userName;

  Long postId;

  String postTitle;
  
}
