package com.codewave.demo.userdatabase.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRespDto {

  Long id;

  String fullName;

  String userName;

  String email;

  String phone;

  String website;

}
