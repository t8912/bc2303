package com.codewave.demo.service;

//import org.springframework.stereotype.Service;

import com.codewave.demo.foundation.exception.NotFoundException;
import com.codewave.demo.model.Account;

//@Service
public interface DatabaseService {

  Account createAccountService() throws Exception;

  Account findAccountService(Long id) throws NotFoundException;

  boolean deleAccountById(Long id);

  Account updateAccountById(Long id, Account account) throws NotFoundException;

  Account updateAccountEmail(Long id, String email) throws NotFoundException;

  // TODO: handle exception

}
