package week3.classes;

 public class RectangleT {
  private double length;
  private double width;
  private static final int NUM_SIDES = 4;
  
  public RectangleT(double length, double width) {
      this.length = length;
      this.width = width;
  }
  
  public double getLength() {
      return length;
  }
  
  public double getWidth() {
      return width;
  }
  
  public double getArea() {
      return length * width;
  }
  
  public double getPerimeter() {
      return 2 * (length + width);
  }
  
  public static int getNumSides() {
      return NUM_SIDES;
  }
  
  private double calculateDiagonal() {
      return Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2));
  }
  
  public void printInfo() {
      System.out.println("Length: " + length);
      System.out.println("Width: " + width);
      System.out.println("Area: " + getArea());
      System.out.println("Perimeter: " + getPerimeter());
      System.out.println("Diagonal: " + calculateDiagonal());
  }
}