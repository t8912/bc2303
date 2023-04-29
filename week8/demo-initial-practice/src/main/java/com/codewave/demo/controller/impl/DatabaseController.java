package com.codewave.demo.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewave.demo.controller.DataBaseOperations;
import com.codewave.demo.foundation.exception.BizCode;
//import com.codewave.demo.foundation.exception.BizCode;
import com.codewave.demo.foundation.exception.NotFoundException;
import com.codewave.demo.foundation.response.ApiResponse;
import com.codewave.demo.model.Account;
import com.codewave.demo.model.TransferRecord;
import com.codewave.demo.service.DatabaseService;
import com.codewave.demo.service.TransferService;

//@Controller // Provide Web Server Ability to interact with consumer via network
//@ResponseBody // JSON & HTTP rsponse
@RestController // @Controller + @REsponseBody
@RequestMapping(value = "/demo/practice/api/v1")
public class DatabaseController implements DataBaseOperations {

  @Autowired
  DatabaseService databaseService;

  /// private static int counter = 0;

  @Autowired
  TransferService transferService;

  @Override
  public ResponseEntity<ApiResponse<Account>> createAccount() throws Exception {
    // public ResponseEntity<ApiResponse<Account>> createAccount() {
    // Account account = Account.builder().id(++counter).build(); // Business Logic

    ApiResponse<Account> response = ApiResponse.<Account>builder()
        .ok()
        .data(databaseService.createAccountService())
        .build();
    return ResponseEntity.ok().body(response);

  }

  @Override
  public ResponseEntity<ApiResponse<Account>> getAccount(Long id) {
    Account account = null;
    ApiResponse<Account> response = null;

    try {
      account = databaseService.findAccountService(id);
      response = ApiResponse.<Account>builder()
          .ok()
          .data(account)
          .build();
    } catch (NotFoundException e) {
      response = ApiResponse.<Account>builder()
          // .success(BizCode.RESOURCE_NOT_FOUND.isSuccess())
          // .code(BizCode.RESOURCE_NOT_FOUND.getCode())
          // .message(BizCode.RESOURCE_NOT_FOUND.getMessage())
          // .metadata(BizCode.RESOURCE_NOT_FOUND)
          .error(e)
          .data(null)
          .build();

    }

    return ResponseEntity.ok().body(response);

  }

  @Override
  public ResponseEntity<ApiResponse<Boolean>> deleteAccount(Long id) {
    ApiResponse<Boolean> response = null;
    boolean result = databaseService.deleAccountById(id);
    if (result) {
      response = ApiResponse.<Boolean>builder()
          .ok()
          .data(result)
          .build();
    } else {
      response = ApiResponse.<Boolean>builder()
          .error(new NotFoundException())
          .data(result)
          .build();
    }
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<Account>> updateAccount(Long id, Account account) throws Exception {
    ApiResponse<Account> response = null;
    Account result = databaseService.updateAccountById(id, account);
    if (result != null) {
      response = ApiResponse.<Account>builder()
          .ok()
          .data(result)
          .build();
    } else {
      response = ApiResponse.<Account>builder()
          .error(new NotFoundException())
          .data(result)
          .build();
    }
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<Account>> updateAccountEmail(Long id, String email) throws Exception {
    ApiResponse<Account> response = null;
    Account result = databaseService.updateAccountEmail(id, email);
    if (result != null) {
      response = ApiResponse.<Account>builder()
          .ok()
          .data(result)
          .build();
    } else {
      response = ApiResponse.<Account>builder()
          .error(new NotFoundException())
          .data(result)
          .build();
    }
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<TransferRecord>> getTransferRecord(Long id) {
    TransferRecord transferRecord = transferService.findTransferRecordById(id);
    ApiResponse<TransferRecord> response = null;
    if (transferRecord != null) {
      response = ApiResponse.<TransferRecord>builder()
          .ok() // 20000
          .data(transferRecord)
          .build();
    } else {
      response = ApiResponse.<TransferRecord>builder()
          .bizCode(BizCode.RESOURCE_NOT_FOUND)
          .data(null)
          .build();
    }
    return ResponseEntity.ok().body(response); // 200
  }
}