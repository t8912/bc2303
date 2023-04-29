package com.codewave.demo.model;

public enum Entry {
  CREDIT('C') //
  , DEBIT('D') //
  ;

  char dbValue;

  private Entry(char dbValue) {
    this.dbValue = dbValue;

  }

}
