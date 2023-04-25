package com.codewave.demo.foundation.response;

import com.codewave.demo.foundation.exception.BizCode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class ApiResponse<T> {
  boolean success;
  int code;
  String message;
  T data;

  public ApiResponse(Builder<T> builder) {
    this.success = builder.success;
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  // error, please complete it
public static <T> Builder<T> builder() {
  return new Builder<>();
}


public static class Builder<T> {
  boolean success;
  int code;
  String message;
  T data;

  public Builder<T> success() {
    this.success = BizCode.SUCCESS.isSuccess();
    this.code = BizCode.SUCCESS.getCode();
    this.message = BizCode.SUCCESS.getMessage();
    return this;
  }


  // Add code
  public Builder<T> success(boolean success) {
    this.success = success;
    return this;
  }

  public Builder<T> code(int code) {
    this.code = code;
    return this;
  }

  public Builder<T> message(String message) {
    this.message = message;
    return this;
  }

  public Builder<T> data(T data) {
    this.data = data;
    return this;
  }

public ApiResponse<T> build() {
  return new ApiResponse<>(this);
}

}
}


// method success()
//public static <T> ApiResponseBuilder<T> success() {
///  return ApiResponse.<T>builder().success(true);
////}


/*
 * public ApiResponse<T> success2()) {
  success = true;
  code = 20000;
  message = "SUCESS";
  return this;
}
 */

  
//}

// {
// "success" : true
//"code" : 20000
//"message" "SUCCESS"
//"data : {}"
// }