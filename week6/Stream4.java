package week6;

import java.util.ArrayList;
import java.util.List;

public class Stream4 {

  public static void main(String[] args) {
    List<Car> cars = new ArrayList<>();

    cars.add(new Car(null, "Yellow"));
    cars.add(null);
    cars.add(new Car(null, "Black"));

    Car[] carArr = cars.stream()//
    .filter(e -> e != null) //
    .toArray(e -> new Car[e]); // for non-primitive only
    
    for (Car c : carArr) {
      System.out.println(c.getColor());
      //System.out.println(c);
    }
    
  }
  
}
