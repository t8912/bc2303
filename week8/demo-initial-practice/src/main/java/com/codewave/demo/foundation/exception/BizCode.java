package com.codewave.demo.foundation.exception;

import lombok.Getter;

@Getter
public enum BizCode {

  // 20000
  SUCCESS(20000, true, "SUCCESS"), 
  // Fail 40000 - 49999
  AATOCK_TIMEOUT(20001, false, "Connect AATOCK TIMOUT"),
  DEFAULT(99999, false, "Unkown") //
  ;

  private int code;
  private boolean success;
  private String message;

  private BizCode(int code, boolean success, String message) {
    this.code = code;
    this.success = success;
    this.message = message;
  }
  
}
