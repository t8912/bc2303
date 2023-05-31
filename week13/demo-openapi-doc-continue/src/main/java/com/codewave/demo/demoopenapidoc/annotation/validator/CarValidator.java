package com.codewave.demo.demoopenapidoc.annotation.validator;

import com.codewave.demo.demoopenapidoc.annotation.ValidCar;
import com.codewave.demo.demoopenapidoc.model.Car;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CarValidator implements ConstraintValidator<ValidCar, Car> {

  @Override
  public void initalize (ValidCar constraintAnnotation) {

  }

  @Override
  public boolean isValid(Car car, ConstraintValidatorContext context) {
    if (car.getColor() == null && (car.getModel() == null) || "".equals(car.getModel())) 
    return false;
    return true;
  }
  
}
