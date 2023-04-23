package week6;

public class Father implements Driver {
  
  @Override
  public double accelerte(double originalSpeed) {
     return originalSpeed + 50.0;
  }

  public static void main(String[] args) {
    Car car = Car.builder() //
    .driver(e -> e + 50.0) // lambda
    //.driver(new Father()) // Father implementation
    .color("Red")
    .build();
    System.out.println(car.getEngine());

    car.startEngine(e -> e + 100.00);
  }
  
}
