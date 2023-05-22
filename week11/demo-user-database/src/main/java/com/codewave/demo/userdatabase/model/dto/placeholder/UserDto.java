package com.codewave.demo.userdatabase.model.dto.placeholder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
  
  Long id;
  String name;
  String username;
  String email;
  String phone;
  String website;

}
