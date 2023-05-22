package com.codewave.demo.controller;

//import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.codewave.demo.hktvmall.Infra.response.ApiResponse;
import com.codewave.demo.model.Account;
//import com.codewave.demo.model.TransferRecord;
import com.codewave.demo.model.TransferRecord;

public interface DataBaseOperations {

  // New Resource ( Similar to the meaning of Insert)
  // @PostMapping
  // List<TransferRecord> create

  @PostMapping(value = "/account")
  ResponseEntity<ApiResponse<Account>> createAccount() throws Exception;

  // @GetMapping(value = "/account/{number}") // number
  // ResponseEntity<ApiResponse<Account>> getAccount(@PathVariable(value =
  // "number") Integer id); // "number"
  @GetMapping(value = "/account")
  ResponseEntity<ApiResponse<Account>> getAccount(@RequestParam(value = "number") Long id); // "number"

  // Delete Account By Id
  @DeleteMapping(value = "/account/{id}")
  // ResponseEntity<ApiResponse<Boolean>> deleteAccount(@PathVariable(value =
  // "id") Integer id); // throws Exception;
  ResponseEntity<ApiResponse<Boolean>> deleteAccount(@PathVariable(value = "id") Long id);
  // ResponseEntity<ApiResponse<Void>> deleteAccount(Integer id); // return
  // nothing, normally don't use it, waste

  // Put by id -> Update Resource(Account)
  @PutMapping(value = "/account/{id}")
  ResponseEntity<ApiResponse<Account>> updateAccount(@PathVariable(value = "id") Long id,
      @RequestBody Account account) throws Exception;

  @PatchMapping(value = "/account/{id}/email/{email}")
  ResponseEntity<ApiResponse<Account>> updateAccountEmail(@PathVariable(value = "id") Long id,
      @PathVariable(value = "email") @RequestBody String email) throws Exception;

  @GetMapping(value = "/transfer/{id}")
  ResponseEntity<ApiResponse<TransferRecord>> getTransferRecord(@PathVariable(value = "id") Long id);

}
