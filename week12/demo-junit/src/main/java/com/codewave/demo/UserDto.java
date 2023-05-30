package com.codewave.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

  private String firstName;

  private String lastName;

  private String email;

  public static List<UserDto> convert(List<User> users) {
    return users.stream()
        .map(e -> UserDto.builder()
            .firstName(e.getFirstName())
            .lastName(e.getLastName())
            .email(e.getEmail())
            .build())
        .collect(Collectors.toList());
  }

}
