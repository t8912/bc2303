package com.codewave.demo;

public class Circle implements Shape {

  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  public double area() {
    return this.radius * this.radius * 3.14;
  }

}
