package com.codewave.demo.demoopenapidoc.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.demo.demoopenapidoc.controller.CarParkOperations;
import com.codewave.demo.demoopenapidoc.model.Car;
import com.codewave.demo.demoopenapidoc.service.impl.CarParkserviceHolder;


@RestController
@RequestMapping(value = "/v1")
public class CarParkController implements CarParkOperations {

  @Autowired
  CarParkserviceHolder carParkserviceHolder;

  @Override
  public List<Car> getCars() {
    return carParkserviceHolder.getCars();
  }

  @Override
  public Car createCar(Car car) {
    return carParkserviceHolder.createCar(car);
  }
  
}

