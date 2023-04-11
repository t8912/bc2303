package week5.shapes;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public abstract class Shape {

  public abstract BigDecimal area();

  // public double calcArea(List<Shape> shapes) {
  public static <T extends Shape> BigDecimal calcArea(List<T> shapes) {
    // sum of the total area of all shapes (Circle/ Square)
    BigDecimal totalArea = BigDecimal.valueOf(0.0);
    for (T s : shapes) {
      totalArea = totalArea.add(s.area()); // circle.area(), square.area()
    }
    return totalArea;
  }

  public static void main(String[] args) {
    Circle circle = new Circle(5);
    // circle.setRadius(5);
    Square square = new Square(7);
    // square.setLength(7);
    System.out.println(Shape.calcArea(Arrays.asList(circle, square)));
  }
}



