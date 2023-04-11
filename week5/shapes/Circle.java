package week5.shapes;

import java.math.BigDecimal;

public class Circle extends Shape {
  private BigDecimal radius;
  private static final BigDecimal PI = BigDecimal.valueOf(3.14);

   public Circle(BigDecimal radius) {
    this.radius = radius;
   }

   public Circle(double radius) {
    this.radius = BigDecimal.valueOf(radius);
   }

  public void setRadius(BigDecimal radius) {
    this.radius = radius;
  }

  public void setRadius(double radius) {
    this.radius = BigDecimal.valueOf(radius);
  }

  public BigDecimal area() {
   return this.radius.multiply(this.radius).multiply(PI);   
  }
  
}
