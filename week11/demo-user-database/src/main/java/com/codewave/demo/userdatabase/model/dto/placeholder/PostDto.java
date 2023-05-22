package com.codewave.demo.userdatabase.model.dto.placeholder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {

  Long id;
  Long userId;
  String title;
  String body;

}
