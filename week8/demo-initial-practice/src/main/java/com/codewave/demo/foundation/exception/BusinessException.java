package com.codewave.demo.foundation.exception;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends Exception {

  private int code;

  public BusinessException(int code, String message) {
    super(message);
    this.code = code;
  }

  public BusinessException(int code, String message, Throwable cause) {
    super(message, cause);
    this.code = code;

  }
}