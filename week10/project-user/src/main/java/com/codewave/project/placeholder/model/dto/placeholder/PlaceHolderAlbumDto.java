//package com.codewave.project.placeholder.model.dto.placeholder;

//public class PlaceHolderAlbumDto {
  
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
public class PlaceHolderAlbumDto {

  private Long id;
  private Long userId;
  private String title;

}
