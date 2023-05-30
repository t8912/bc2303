package com.codewave.demo;

import java.util.Arrays;
import java.util.List;

public final class Java11 {

  public static void main(String[] args) {
    //Java 11
    String str = '\u2000' +  "I am learning Java in Bootcamp.";
    String str2 = "   ";

    System.out.println(str.strip().length()); // remove all space, including \u2000
    System.out.println(str.stripLeading().length()); // remove \u2000 as leading space
    System.out.println(str.stripTrailing().length()); // no trailing space
    System.out.println(str.trim().length()); // trim single space, cannot remove  \u2000


    System.out.println(str2.length());
    System.out.println(str2.stripLeading().length());
    System.out.println(str2.stripTrailing().length());
    System.out.println(str2.trim().length());


    String str3 = "boy";
    System.out.println(str3.repeat(10));
    
    String str4 = "  ";
    String str5 = "";
    System.out.println("st4.isBlank()=" + str4.isBlank()); // trim() + isEmpty()
    System.out.println("st5.isBlank()=" + str5.isBlank());
  
    System.out.println("st4.isBlank()=" + str4.isEmpty());
    System.out.println("st5.isBlank()=" + str5.isEmpty());

    List<String> strings = Arrays.asList("YES", "NO");
    for (String s : strings.toArray(new String[]{})) {
      System.out.println(s);
    }

  }
  
}
