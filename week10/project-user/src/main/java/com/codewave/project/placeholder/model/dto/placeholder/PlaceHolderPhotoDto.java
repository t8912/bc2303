//package com.codewave.project.placeholder.model.dto.placeholder;

//public class PlaceHolderPhotoDto {
  
//}

package com.codewave.project.placeholder.model.dto.placeholder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaceHolderPhotoDto {

  Long id;
  Long albumId;
  String title;
  String url;
  String thumbnailUrl;

}
