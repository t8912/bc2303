package com.codewave.demo.openapidoc.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.demo.openapidoc.controller.CarParkOperations;
import com.codewave.demo.openapidoc.model.Car;
import com.codewave.demo.openapidoc.model.Color;
import com.codewave.demo.openapidoc.service.impl.CarParkServiceHolder;

@RestController
@RequestMapping(value = "/v1")
public class CarParkController implements CarParkOperations {

  @Autowired
  CarParkServiceHolder carParkServiceHolder;

  @Override
  public List<Car> getCars() {
    return carParkServiceHolder.getCars();
  }

  @Override
  public List<Car> getCars(Color color) {
    return carParkServiceHolder.getCars(color);
  }

  @Override
  public Car createCar(Car car) {
    return carParkServiceHolder.createCar(car);
  }
}
