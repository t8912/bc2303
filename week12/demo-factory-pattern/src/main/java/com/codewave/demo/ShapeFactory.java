package com.codewave.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShapeFactory {

  public static Shape getShape(String shapeType, List<Double> shapeParams) {
    // Can use a Map<String, List<BigDecimal>>
    System.out.println(shapeType + " " + shapeParams.toString() + shapeParams.get(0));
    if (shapeType == null || shapeParams == null)
      return null;
    if ("CIRCLE".equalsIgnoreCase(shapeType) && shapeParams.get(0) != null) {
      return new Circle(shapeParams.get(0));
    } else if ("RECTANGLE".equalsIgnoreCase(shapeType)
        && shapeParams.get(0) != null && shapeParams.get(1) != null) {
      return new Rectangle(shapeParams.get(0), shapeParams.get(1));
    }
    return null;
  }

  public static void main(String[] args) {
    Map<String, List<Double>> sources = new HashMap<>();
    sources.put("CIRCLE", Arrays.asList(5.0));
    sources.put("RECTANGLE", Arrays.asList(2.3, 5.9));

    List<Shape> shapes = new ArrayList<>();
    for (Map.Entry<String, List<Double>> entry : sources.entrySet()) {
      shapes.add(ShapeFactory.getShape(entry.getKey(), entry.getValue()));
    }
    System.out.println(Shape.totalArea(shapes));
  }

}
