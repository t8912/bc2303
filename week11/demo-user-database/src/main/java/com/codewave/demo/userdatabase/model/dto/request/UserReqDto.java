package com.codewave.demo.userdatabase.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReqDto {

  String fullName;

  String userName;

  String email;

  String phone;

  String website;

}
