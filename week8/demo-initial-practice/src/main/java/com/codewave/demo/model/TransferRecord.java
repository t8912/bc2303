package com.codewave.demo.model;

import java.math.BigDecimal;

//import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferRecord {


  Integer fromAccount;
  Entry fromEntry;
  Integer toAccount;
  Entry toEntry;
  BigDecimal amount;

  private TransferRecord(Integer fromAccount, Entry fromEntry, Integer toAccount, Entry toEntry, BigDecimal amount) {
    this.fromAccount = fromAccount;
    this.fromEntry = fromEntry;
    this.toAccount = toAccount;
    this.toEntry = toEntry;
    this.amount = amount;
  }

  private TransferRecord(Integer fromAccount, Entry fromEntry, Integer toAccount, Entry toEntry) {
    this.fromAccount = fromAccount;
    this.fromEntry = fromEntry;
    this.toAccount = toAccount;
    this.toEntry = toEntry;
  }

  public TransferRecord(Integer fromAccount, Entry fromEntry, Integer toAccount, Entry toEntry, Integer amount) {
    this(fromAccount, fromEntry, toAccount, toEntry);
    this.amount = BigDecimal.valueOf(amount);
  }

  public static TransferRecord createTransferRecord(Integer fromAccount, Integer toAccount, Integer amount) {
    return new TransferRecord(fromAccount, Entry.DEBIT, toAccount, Entry.CREDIT, amount);
  }
}
