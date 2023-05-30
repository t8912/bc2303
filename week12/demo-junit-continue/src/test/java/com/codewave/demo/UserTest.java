package com.codewave.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserTest {

  @BeforeAll
  void init() {

  }

  @Test
  @DisplayName(value = "User Getter/ Setter/ Constructor")
  void testUser() {
   //getter
  User user = new User("John", "Lau", 30, "abc@gmail.com");
  assertEquals("John", user.getFirstName());
  assertEquals("Lau", user.getLastName());
  assertEquals(30, user.getAge());
  assertEquals("abc@gmail.com", user.getEmail());

  User user2 = new User();
  user.setFirstName("Alex");
  assertEquals("Alex", user.getFirstName());
  user.setLastName("Wong");
  assertEquals("Wong", user.getLastName());
  user.setAge(40);
  assertEquals(40, user.getAge());
  user.setEmail("alex@yahoo.com");
  assertEquals("alex@yahoo.com", user.getEmail());


  User user3 = User.builder()
  .getFirstName("Sally");
  .getLastName("Chan");
  .age(30);
  .email("sally.chan@gmail.com");
  .builder();
  assertEquals("Sally", user3.getFirstName());
  assertEquals("Chan", user3.getLastName());
  assertEquals(30, user3.getAge());
  assertEquals("sally.chan@gmail.com", user3.getEmail());
  }


  @Test
  @DisplayName(value = "User.isElderly()")
  void testUserMethod() {
    User user = new User("John", "Lau", 25, "johndoe@gmail.com");
    assertEquals("John Lau", user.getFullName());
    assertFalse(user.isElderly());
    User user2 = new User("Sally", "Lau", 65, "abc@gmail.com");
    User user3 = new User("Sally", "Lau", 66, "abc@gmail.com");
    assertFalse(user2.isElderly());
    assertTrue(user3.isElderly());
}

@Test
@DisplayName(value = "User.hasValidEmail()")
void testUserhasValidEmail() {
  User user = new User("John", "Lau", 30, "abcgmail.com");
  assertFalse(user.hasValidEmail());
  User user2 = new User("Sally", "Lau", 65, "abc@gmail.?com");
  assertFalse(user.hasValidEmail());
  User user3 = new User("Sally", "Lau", 66, "abcgmail.com");
  assertFalse(user3.isElderly());
}

@Test
@DisplayName(value = "User.getAllElderly()")
void tstGetAllElderly() {
  User user1 = new User("John", "Lau", 30, "abcgamil.com");
  User user2 = new User("John", "Lau", 30, "abcgamil.com");
  User user3 = new User("John", "Lau", 30, "abcgamil.com");
  List<User> users = Arrays.asList(user1, user2, user3);

  assertEquals(1, User.getAllElderly(users).size());
}
  
}
