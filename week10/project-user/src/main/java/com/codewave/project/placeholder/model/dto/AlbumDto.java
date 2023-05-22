//package com.codewave.project.placeholder.model;

//public class AlbumDto {
  
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
public class AlbumDto {

  Long id;
  Long userId;
  String title;

}
