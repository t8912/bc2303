package com.codewave.demo.postgresql.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRespDto {
  

  Long id;
  
  String title;

  String body;
  
}


