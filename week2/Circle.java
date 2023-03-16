package week2;

public class Circle extends Shape {

  private double radius;
  private static final double pi = 3.14;

  public void setRadius(double radius) {
    this.radius = radius;
  }

  @Override
  public double area() {
    return this.radius * this.radius * pi;
  }

  public static double area(double radius) {
    return radius * radius * pi;
  }

  public static void main(String[] args) {
    Circle circle = new Circle();
    circle.setRadius(3);
    System.out.println("area=" + circle.area());

    // calculate circle area
    System.out.println(area(10));
  }
}
