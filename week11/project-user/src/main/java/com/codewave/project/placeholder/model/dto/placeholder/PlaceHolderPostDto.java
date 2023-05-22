package com.codewave.project.placeholder.model.dto.placeholder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaceHolderPostDto {

  Long userId;
  Long id;
  String title;
  String body;

}
