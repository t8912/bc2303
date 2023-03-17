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

  public abstract void sleep();
  
}
