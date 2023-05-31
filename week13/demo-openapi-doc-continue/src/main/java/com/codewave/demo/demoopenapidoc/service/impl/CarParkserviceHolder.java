package com.codewave.demo.demoopenapidoc.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.codewave.demo.demoopenapidoc.data.BigCarPark;
import com.codewave.demo.demoopenapidoc.model.Car;
import com.codewave.demo.demoopenapidoc.model.Color;
//import com.codewave.demo.demoopenapidoc.model.CarPark;
import com.codewave.demo.demoopenapidoc.service.CarParkService;

//import jakarta.validation.OverridesAttribute.List;

@Service
public class CarParkserviceHolder implements CarParkService  {

  @Override
  public Car createCar(Car car) {

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
