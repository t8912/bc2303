package com.codewave.demo;

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
public class User {

  private String firstName;

  private String lastName;

  private int age;

  private String email;

  public static List<User> getAllElderly(List<User> users) {
    return users.stream()
        .filter(user -> user.isElderly())
        .collect(Collectors.toList());
  }

  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }

  public boolean isElderly() {
    return this.age > 65;
  }

  public boolean hasValidEmail() {
    // contain @ symbol
    // domain name: [A-Z][a-z][0-9].-
    // Recipient name: no rules
    if (this.email.indexOf("@") == -1)
      return false;
    String domain = this.email.split("@")[1]; // String[] -> String
    boolean isValid = false;
    for (int i = 0; i < domain.length(); ++i) {
      isValid = false;
      if (domain.charAt(i) == '-' || domain.charAt(i) == '.')
        isValid = true;
      if (domain.charAt(i) >= 97 && domain.charAt(i) <= 122)
        isValid = true;
      if (domain.charAt(i) >= 65 && domain.charAt(i) <= 90)
        isValid = true;
      if (!isValid)
        return false;
    }
    return true;
  }

}
