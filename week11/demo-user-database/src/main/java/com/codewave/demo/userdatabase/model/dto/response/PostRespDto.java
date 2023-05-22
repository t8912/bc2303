package com.codewave.demo.userdatabase.model.dto.response;

import com.codewave.demo.userdatabase.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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

  User user;

}
