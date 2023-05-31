package com.codewave.demo.demoopenapidoc.service;

import java.util.List;

import com.codewave.demo.demoopenapidoc.model.Car;
import com.codewave.demo.demoopenapidoc.model.Color;

public interface CarParkService {

  Car createCar(Car car);
  
  List<Car> getCars();

  List<Car> getCars(Color color);


  
}
