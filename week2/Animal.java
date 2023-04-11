package week2;

import java.time.Instant;

public abstract class Animal {

  String name;
  String height;

  public Animal() {

  }

  public Animal(String name, String height) {
    this.name = name;
    this.height = height;
  }

  public void setName(String name) {
    this.name = name;
  }

  public abstract void sound();

  public String sound2() {
    return "Meow Meow";
  }

  public int sum(int x, int y) {
    return x + y;
  }

  public static void main(String[] args) {
    Exam exam = new Exam();
    // Animal animal = new Animal("Cat", null);
    // Animal animal2 = new Animal();
    // animal.sound();
    // String sound = animal.sound2();
    // int result = animal.sum(1, 2);
    // System.out.println(result);
    System.out.println(Instant.now().toEpochMilli());
    // 1678873218629
    // 1678873273437
    //       3600000
    // 1678876349388
  }

}

/*
 * public abstract class Animal {
  
 String name;
 String height;
 //String color; 

public abstract void sound()

public String sound2() {
  return "Meow Meow";
}

 public Animal(){
  
 }

public Animal(String color, String name, String height){
  
}

 public Animal(String name) {
  this.name = name;
 }

 public void setName(String name) {
  this.name = name;
 }

}

 */

