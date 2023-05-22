package com.codewave.demo.userdatabase.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRespDto {

  Long id;

  String fullName;

  @JsonProperty("loginName")
  String userName;

  @JsonProperty("email")
  String userEmail;

  @JsonProperty("phone")
  String userPhone;

  @JsonProperty("website")
  String userWebsite;

  
}
