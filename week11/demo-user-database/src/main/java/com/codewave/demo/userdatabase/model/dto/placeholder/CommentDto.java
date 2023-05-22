package com.codewave.demo.userdatabase.model.dto.placeholder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {

  Long id;
  Long postId;
  String name;
  String body;

}
