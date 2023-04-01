package week3.classes;

import javax.sql.rowset.spi.TransactionalWriter;

public class Triangle extends Shape3 {

  double base;
  double height;

  public Triangle() {

  }

  public Triangle(double base, double height) {
    this.base = base;
    this.height = height;
  }

  public double getBase() {
    return this.base;
  }

  @Override
  public double calcArea() {
    return base * height / 2;
  }

  public String sound() {
    return "I am Triangle";
  }

  /// public static void main(String[] args) {
  // This is an example, explaining chapter 11
  /// Shape3 shape3 = new Triangle(3, 7);
  // shape3.getbase(); // cannot read getbase() fronm parent object
  /// Triangle triangle = null;
  /// if (shape3 instanceof Triangle) {
  /// triangle = (Triangle)shape3 ; //may be runtimr error, so we should check
  /// instead of
  //
  // Triangle triangle = (Triangle) shape3; // runtime
  /// System.out.println(triangle.getBase()); //3.0
  /// }
  /// }
  /// }




  

  public static void main(String[] args) {
    // This is an example, explaining chapter 11
    Shape3 shape3 = new Rectangle(3, 7);
    // shape3.getbase(); // cannot read getbase() fronm parent object
    Triangle triangle = null;
    if (shape3 instanceof Triangle) {
      triangle = (Triangle) shape3; // may be runtimr error, so we should check instead of
      //
      // Triangle triangle = (Triangle) shape3; // runtime
      System.out.println(triangle.getBase()); // 3.0
    }
  }
}
