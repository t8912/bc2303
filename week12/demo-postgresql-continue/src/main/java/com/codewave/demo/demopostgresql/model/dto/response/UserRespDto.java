package com.codewave.demo.demopostgresql.model.dto.response;

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

  private Long id;

  private String fullName;

  private String userName;

  private String email;

  private String phone;

  private String website;
}

// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @Builder
// public class UserRespDto {

//   Long id;

//   String fullName;

//   String userName;

//   String email;

//   String phone;

//   String website;

// }
