package week3.classes;

public class Rectangle extends Shape3{

  double length;
  double width;

  public Rectangle(double a, double b) {
    this.length = a;
    this.width = b;
  }

  @Override
  public double calcArea() {
    return length * width;
  }

  public double perimeter() {
    return (length + width) * 2;
  }
  
}
