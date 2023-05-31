package com.codewave.demo.openapidoc.data;

import java.util.List;

import com.codewave.demo.openapidoc.model.Car;
import com.codewave.demo.openapidoc.model.CarPark;

public class BigCarPark {

  private final static CarPark carPark; // final, cannot be null

  static {
    carPark = new CarPark();
    carPark.init();
  }

  public static List<Car> getCarListFromCarPark() {
    return carPark.getCars();
  }

}
