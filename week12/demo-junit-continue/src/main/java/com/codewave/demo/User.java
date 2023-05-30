package com.codewave.demo;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

  private String firstName;

  private String lastName;

  private String email;

  private int age;

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
    

    if (this.email.indexOf("@") == -1)
       return false;

       String[] strs = this.email.split("@");
       String domain = strs[1];
       for (int i = 0; i < domain.length(); ++i) {

        char ch = domain.charAt(i);
        if (!Character.isLetter(ch) && !Character.isDigit(ch) && ch != '.') {
            return false;
        }
    }

    return true;

       }

      }
      // String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
      // return email.matches(emailRegex);
  
  
  
  

