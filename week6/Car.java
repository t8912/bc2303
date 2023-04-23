package week6;

public class Car {

  private Driver driver; // state

  private String color; // state

  private double engine;

  public Car() {
  }

  public Car(Driver driver, String color) {
    this.driver = driver;
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  public Car(Builder1 builder1) {
    this.driver = builder1.getDriver();
    this.color = builder1.getColor();
  }

  public double getEngine() {
    return this.engine;
  }

  public void startEngine(Driver driver) {
    this.engine += driver.accelerte(engine);
  }

  public static Builder1 builder() {
    return new Builder1();
  }

  public void setDriver(Driver driver) {
    this.driver = driver;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return "[" //
        + "driver=" + this.driver
        + ", "
        + "color=" + this.color
        + "]";
  }

  public class Builder { // non-static
    private int age;

    public void setAge(int age) {
      this.age = age;
    }

    public int getAge() {
      return this.age;
    }

   
  }

  public static class Builder1 { // static
    private Driver driver;
    private String color;

    public Builder1 driver(Driver driver) {
      this.driver = driver;
      return this;
    }

    public Builder1 color(String color) {
      this.color = color;
      return this;
    }

    public Driver getDriver() {
      return this.driver;
    }

    public String getColor() {
      return this.color;
    }

    public Car build() {
      return new Car(this);
    }
  }

  public static void main(String[] args) {
    // Traditional way of initialization
    Car car = new Car();
    car.setColor("Yellow"); // 
    Car car2 = new Car(new Father(), "Yellow"); //

    Car.Builder b = new Car().new Builder();
    b.setAge(3);
    System.out.println(b.getAge()); // 3
    
    // Builder Pattern (Builder1 class)
    Car b1 = Car.builder() //
        .driver(new Father()) //
        .color("Yellow") //
        .build();
    System.out.println(b1.toString()); // [driver=John, color=Yellow]

  }
}



//////////////////////////////////

/*
 * public class Car {

private String driver; //state

private String color; //state

public Car() {

}

public Car(String driver, String color) {
  this.driver = driver;
  this.color = color;
}

public Car(Builder1 builder1) {
  this.driver = builder1.getDriver();
 this.color = builder1.getColor();
}

public static Builder1 builder() {
  return new Builder1();
}

public void setDriver(String driver) {
  this.driver = driver;
}

public void setColor(String color) {
  this.color = color;
}

@Override
public String toString() {
  return "["//
  + "driver=" + this.driver
  + ", "
  + "color=" + this.driver
  +"]";
}

public class Builder { // non-static
  private int age;


public void setAge(int age) {
  this.age = age;
}

public int getAge() {
  return this.age;
}
}

public static class Builder1 { // static
 private String driver;
 private String color;

 public Builder1 builder() {
  return new Builder1();
 }

   public Builder1 setDriver(String driver) {
    this.driver = driver;
    return this;
   }

   public Builder1 setColor(String color) { ///
    this.color = color;
    return this;
   }

public String getDriver() {
  return this.driver;
}

public String setColor() {
  return this.color;
}

public Car build() {
  return new Car(this);
}


}

  public static void main(String[] args) {
     //Traditional way of initialization
    Car car = new Car();
    car.setColor("Yellow"); //
    Car car2 = new Car("Yellow", null); //

    //Builder builder = new Builder()
    //Car car3 = new Car.Builder()

    Car.Builder b = new Car().new Builder(); // Object inner new object
    b.setAge(3);
    System.out.println(b.getAge());


    //Builder Pattern
   Car b1 = Car.builder()//
   .driver("John")//
   .color("Yellow")//
   .build();

   System.out.println(b1.toString()); // John, yellow
  }
  
}


 */
