package com.codewave.demo.postgresql.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {

  String fullName;

  String userName;

  String email;

  String phone;

  String website;

}
