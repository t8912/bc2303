package com.codewave.demo.userdatabase.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    Long id;
    String title;
    String body;
    UserDto user;
}



/* 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
  
  Long id;
  String postTitle;
  String postBody;
  UserDto user;

}

*/



/* 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {

  //Long userId;
  //Long id;
  //String title;
  //String body;

  /////////

  Long id;
  String postTitle;
  String postBody;
  UserDto user;

}

*/
