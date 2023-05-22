package com.codewave.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.codewave.demo.hktvmall.Infra.response.ApiResponse;
import com.codewave.demo.model.TransferRecord;

public interface HelloworldOperations {

  @GetMapping(value = "/greeting")
  String sayHello();

  @GetMapping(value = "/transferrecord")
  // ApiResponse<List<TransferRecord>> getTransferRecords();
  ResponseEntity<ApiResponse<List<TransferRecord>>> getTransferRecords();

}
