//package com.codewave.project.placeholder.model;

//public class PhotoDto {
  
//}

package com.codewave.project.placeholder.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhotoDto {

  Long id;
  Long albumId;
  String title;
  String url;
  String thumbnailUrl;

}
