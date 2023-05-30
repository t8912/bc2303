package com.codewave.demo;

public class Rectangle implements Shape {
  
  private double width;
  private double length;

  public Rectangle(double width, double length) {
    this.width = width;
    this.length = length;
  }

  public double area() {
    return this.width * this.length;
  }
  
}
