package com.codewave.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

  @BeforeAll
  static void init() {

  }

  @Test
  @DisplayName(value = "User Getter/ Setter/ Constructor")
  void testUser() {
    // getter/ All Argument Constructor
    User user = new User("John", "Lau", 30, "abc@gmail.com");
    assertEquals("John", user.getFirstName());
    assertEquals("Lau", user.getLastName());
    assertEquals(30, user.getAge());
    assertEquals("abc@gmail.com", user.getEmail());
    // setter
    User user2 = new User();
    user2.setFirstName("Alex");
    assertEquals("Alex", user2.getFirstName());
    user2.setLastName("Wong");
    assertEquals("Wong", user2.getLastName());
    user2.setAge(40);
    assertEquals(40, user2.getAge());
    user2.setEmail("alex@yahoo.com.hk");
    assertEquals("alex@yahoo.com.hk", user2.getEmail());
    // Builder
    User user3 = User.builder()
        .firstName("Sally")
        .lastName("Chan")
        .age(25)
        .email("sally.chan@hotmail.com")
        .build();
    assertEquals("Sally", user3.getFirstName());
    assertEquals("Chan", user3.getLastName());
    assertEquals(25, user3.getAge());
    assertEquals("sally.chan@hotmail.com", user3.getEmail());
  }

  @Test
  @DisplayName(value = "User.getFullName()")
  void testUserGetFullName() {
    User user = new User("John", "Lau", 30, "abc@gmail.com");
    assertEquals("John Lau", user.getFullName());
  }

  @Test
  @DisplayName(value = "User.isElderly()")
  void testUserIsElderly() {
    User user = new User("John", "Lau", 30, "abc@gmail.com");
    assertFalse(user.isElderly());
    User user2 = new User("Sally", "Lau", 65, "abc@gmail.com");
    User user3 = new User("Sally", "Lau", 66, "abc@gmail.com");
    assertFalse(user2.isElderly());
    assertTrue(user3.isElderly());
    
  }

  @Test
  @DisplayName(value = "User.hasValidEmail()")
  void testUserHasValidEmail() {
    User user = new User("John", "Lau", 30, "abcgmail.com");
    assertFalse(user.hasValidEmail());
    User user2 = new User("Sally", "Lau", 65, "abc@gmail.?com");
    assertFalse(user2.hasValidEmail());
    User user3 = new User("Sally", "Lau", 66, "abc@gmail.com");
    assertTrue(user3.isElderly());
  }

  @Test
  @DisplayName(value = "User.getAllElderly()")
  void testGetAllElderly() {
    User user1 = new User("John", "Lau", 30, "abcgmail.com");
    User user2 = new User("Alex", "Lau", 65, "abcgmail.com");
    User user3 = new User("Sally", "Lau", 66, "abcgmail.com");
    List<User> users = Arrays.asList(user1, user2, user3);
    assertEquals(1, User.getAllElderly(users).size());
  }

}
