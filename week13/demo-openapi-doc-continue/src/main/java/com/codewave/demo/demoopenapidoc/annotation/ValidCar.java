package com.codewave.demo.demoopenapidoc.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.codewave.demo.openapidoc.annotation.validator.CarValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validateBy = {CarValidator.class})
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCar {
  String message() default "This Car does not meet our requirements!";

  Class<?> groups() default {};

  Class<? extends Payload>[] payload() default {};

  
}
