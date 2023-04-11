package week5.shapes;

import java.math.BigDecimal;

public class Square extends Shape {

  private BigDecimal length;

  public Square(BigDecimal length) {
    this.length = length;
  }

  public Square(double length) {
    this.length = BigDecimal.valueOf(length);
  }

  public void setLength(BigDecimal length) {
    this.length = length;
  }

  public void setLength(double radius) {
    this.length = BigDecimal.valueOf(radius);
  }

  public BigDecimal area() {
    return this.length.multiply(length);
  }

}
