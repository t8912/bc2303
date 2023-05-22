package com.codewave.demo.userdatabase.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostReqDto {
    String title;
    String body;
    Long userId;
}


/* 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostReqDto {

  private String title;
  private String body;
  private Long userId;
  
}
*/
