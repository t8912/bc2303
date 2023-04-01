package week3.classes;

import week3.interfaces.Swimable;
import week3.interfaces.Walkable;

public abstract class Person implements Walkable, Swimable {

  private double height;
  private double weight;

  public Person(){
    
  }

public Person(double height, double weight) {
  this.height = height;
  this.weight = weight;
}

// Getter Setter for height / weight
public double getHeight() {
  return this.height;
}

public double getWeight() {
  return this.weight;
}

  public abstract void sleep();

//Factory Pattern
  public static Person getPerson(int cat){ //1,2,3...
    if (cat ==1) {
      return new Student();
    } else if (cat == 2) {
      return new Teacher();
    }
   return new Student();
  }
  
}
