package com.codewave.project.placeholder.model.dto.placeholder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaceHolderCommentDto {

  Long postId;
  Long id;
  String name;
  String email;
  String body;

}
