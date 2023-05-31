package com.codewave.demo.openapidoc.model;

import org.springframework.web.context.annotation.RequestScope;

import com.codewave.demo.openapidoc.annotation.ValidCar;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@RequestScope
@ValidCar
public class Car {

  // @NotNull(message = "Custom message for Not null") // business requirement
  private Color color;

  // @NotBlank(message = "Custom message for not blank") // business requirement
  // @Size(min = 3, max = 6) // business requirement
  private String model;

  // @Email
  @Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+", message = "Email format is invalid.")
  private String email;

}
