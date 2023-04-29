package com.codewave.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

//import com.codewave.demo.foundation.exception.BusinessException;
import com.codewave.demo.foundation.exception.NotFoundException;
import com.codewave.demo.model.Account;
import com.codewave.demo.model.TransferRecord;
import com.codewave.demo.service.DatabaseService;

@Service
public class DatabaseServiceImpl implements DatabaseService {

  private static long counter = 0;

  private static List<Account> accounts = new ArrayList<>(); // stack

  @Override
  public Account createAccountService() throws Exception {
    Account account = Account.builder().id(++counter).build();
    if (accounts.add(account))
      return account;
    throw new Exception();
    // return Account.builder().id(++counter).build(); // Business Logic
  }

  @Override
  public Account findAccountService(Long id) throws NotFoundException { // Optional
    return accounts.stream() //
        .filter(e -> e.getId() == id)
        .findFirst()
        // .orElseThrow(() -> new Exception());
        .orElseThrow(() -> new NotFoundException());

  }

  @Override
  public boolean deleAccountById(Long id) {
    try {
      Account account = findAccountService(id);
      accounts.remove(account);
    } catch (NotFoundException e) {
      return false;
    }
    return true;
  }

  @Override
  public Account updateAccountById(Long id, Account account) throws NotFoundException {
    Account result = null;
    try {
      // List -> reference of object 0x123 -> .set() change the object
      result = findAccountService(id); // pass by reference concept // result = 0x123 -> object
      // result = account; // 0x124
      result.setTransferRecords(account.getTransferRecords()); // 0x123

    } catch (NotFoundException e) {
      return null;
    }
    return result;
  }

  @Override
  public Account updateAccountEmail(Long id, String email) throws NotFoundException {
    Account result = null;
    try {
      result = findAccountService(id);
      // result = account; // 0x124
      result.setEmail(email);

    } catch (NotFoundException e) {
      return null;
    }
    return result;
  }

}
