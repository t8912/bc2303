package week3.classes;

public class Rectangle2 {
  private double length;
  private double width;
  //private static final int NUM_SIDES = 4;

  public Rectangle2(double length, double width){
    this.length = length;
    this.width = width;
  }

  public double getLength() {
    return length;
  }

  public double getWidth(){
    return width;
  }

  public double getArea(){
    return length * width;
  }

  private double getPerimeter() {
    return 2 * (length + width);
  }

public void printInfo(){
System.out.println( "Length: " + length);
System.out.println("width: " + width);
System.out.println("Area: " + getArea());
System.out.println("Perimeter: " + getPerimeter());

  }

  public static void main(String[] args) {
    
  }
}
