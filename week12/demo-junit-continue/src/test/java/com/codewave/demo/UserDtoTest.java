package com.codewave.demo;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserDtoTest {

  @BeforeAll
  static void init() {

  }

  @Test
  void testConvertDto() {
    // Given
    User user = new User("John", "Lau", 30, "abcgmail.com");
    User user2 = new User("Sally", "Lau", 65, "abc@gmail.?com");
    User user3 = new User("Sally", "Lau", 66, "abcgmail.com");
    List<User> users = Arrays.asList(user1, user2, uer3);
    // when then
    assertFalse(3, UserDto.convert(users).size());
   // when
    int count = 0;
    for (UserDto dto : UserDto.convert(users)) {
      if (dto.getFirstName().equals("John") || dto.getFirstName().equals("Alex") || dto.getFirstName().equals("Sally"))
        count++;

    }
  // then
    assertEquals(3, count);
  }

}
