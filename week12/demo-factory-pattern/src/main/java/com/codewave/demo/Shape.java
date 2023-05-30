package com.codewave.demo;

import java.util.Arrays;
import java.util.List;

public interface Shape {

  double area();

  static double totalArea(List<Shape> shapes) {
    double totalarea = 0;
    for (Shape s : shapes) {
        totalarea += s.area();
    }
    return totalarea;
  }

  public static void main(String[] args) {
    Circle circle = new Circle(1.5);
    Rectangle rectangle = new Rectangle(2, 3);
    List<Shape> shapes = Arrays.asList(circle, rectangle);
    double totalArea = Shape.totalArea(shapes);
    System.out.println(totalArea); // 13.065
  }

}
