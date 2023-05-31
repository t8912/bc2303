package com.codewave.demo.openapidoc.service;

import java.util.List;

import com.codewave.demo.openapidoc.model.Car;
import com.codewave.demo.openapidoc.model.Color;

public interface CarParkService {

  Car createCar(Car car);

  List<Car> getCars();

  List<Car> getCars(Color color);

}
