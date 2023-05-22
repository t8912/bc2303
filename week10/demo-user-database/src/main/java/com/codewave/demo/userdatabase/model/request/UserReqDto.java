package com.codewave.demo.userdatabase.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReqDto {

  
  String fullName;

  String userName;

  String userEmail;
  
  String userPhone;
  
  String userWebsite;

}

  

