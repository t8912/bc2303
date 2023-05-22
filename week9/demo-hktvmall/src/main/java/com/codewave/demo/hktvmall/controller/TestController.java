package com.codewave.demo.hktvmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.azul.crs.client.Response;
import com.codewave.demo.hktvmall.Infra.response.ApiResponse;
import com.codewave.demo.hktvmall.model.TestObject;

@RestController
@RequestMapping(value = "/test/api/v1")
public class TestController {

  @Autowired
  @Qualifier(value = "testObject2") // Mary
  TestObject testObject; // John or Mary ??

  @GetMapping(value = "/testObject")
  public ResponseEntity<ApiResponse<TestObject>> gettestObject() {
    ApiResponse<TestObject> response = ApiResponse.<TestObject>builder() //
    .ok()
    .data(testObject)
    .build();

    return ResponseEntity.ok().body(response);
  }
}
