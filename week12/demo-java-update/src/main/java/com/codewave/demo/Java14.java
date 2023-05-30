package com.codewave.demo;

import java.util.Objects;

public class Java14 {
  //Immutable Class Design
  private final String name;
  private final int age;

  // No Setter & No Empty Constructor

  public Java14(String name, int age) {
    this.name = name;
    this.age = age;
  }

   public String getName() {
    return this.name;
   }

   public int getAge() {
    return this.age;
   }

   @Override
   public String toString() {
    return "["
          + "name=" + name
          + " ,age" + age   
          + "]";
   }

   @Override
   public int hashCode() {
    return Objects.hash(name, age); // select what you want to compare
    //return Objects.hash(name);
   }

   @Override
   public boolean equals(Object obj) {
    if (obj == null)
    return false;
    if(!(obj instanceof Java14))
    return false;
    Java14 java14 = (Java14) obj;
    return java14.name.equals(this.name) && java14.age == this.age;
     
   }

  public static void main(String[] args) {
    Java14 java14 = new Java14("java14", 10);
    System.out.println(java14.toString());
     //java14.toString();

     Java14 a = new Java14("java14", 23);
     Java14 b = new Java14("java14", 29);
     Java14 c = new Java14("java14", 23);
     System.out.println(a.hashCode() == b.hashCode()); // false
     System.out.println(a.hashCode() == c.hashCode()); // true

     NewJava14 11 = new NewJava14("newJava14", 15); // with No empty constructor & no setter
     NewJava14 b1 = new NewJava14("newJava14", 23);
     NewJava14 c1 = new NewJava14("newJava14", 15);
     System.out.println(a1.toString());
     System.out.println(a1.hashCode() == b1.hashCode()); // false
     System.out.println(a1.hashCode() == c1.hashCode()); // true
  }
  
}
