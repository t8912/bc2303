package com.codewave.demo.openapidoc.annotation.validator;

import com.codewave.demo.openapidoc.annotation.ValidCar;
import com.codewave.demo.openapidoc.model.Car;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CarValidator implements ConstraintValidator<ValidCar, Car> {

  @Override
  public void initialize(ValidCar constraintAnnotation) {

  }

  @Override
  public boolean isValid(Car car, ConstraintValidatorContext context) {
    if (car.getColor() == null && (car.getModel() == null || "".equals(car.getModel())))
      return false;
    return true;
  }
}
