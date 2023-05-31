package com.codewave.demo.openapidoc.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.codewave.demo.openapidoc.data.BigCarPark;
import com.codewave.demo.openapidoc.model.Car;
import com.codewave.demo.openapidoc.model.Color;
import com.codewave.demo.openapidoc.service.CarParkService;

@Service
public class CarParkServiceHolder implements CarParkService {
  // {"color":"RED","model":"123"}
  @Override
  public Car createCar(Car car) {
    System.out.println("car=" + car.toString()); // model=null

    if (BigCarPark.getCarListFromCarPark().add(car))
      return car;
    return null;
  }

  @Override
  public List<Car> getCars() {
    return BigCarPark.getCarListFromCarPark();
  }

  @Override
  public List<Car> getCars(Color color) {
    return BigCarPark.getCarListFromCarPark().stream()
        .filter(car -> car.getColor() == color)
        .collect(Collectors.toList());
  }

}
