package com.codewave.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// @AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TRANSFER_RECORD")
public class TransferRecord implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "FROM_ACCOUNT")
  private Integer fromAccount;

  @Column(name = "FROM_ENTRY")
  @Enumerated(EnumType.STRING)
  private Entry fromEntry;

  @Column(name = "TO_ACCOUNT")
  private Integer toAccount;

  @Column(name = "TO_ENTRY")
  @Enumerated(EnumType.STRING)
  private Entry toEntry;

  private BigDecimal amount;

  private TransferRecord(Long id, Integer fromAccount, Entry fromEntry, Integer toAccount, Entry toEntry,
      BigDecimal amount) {
    this.id = id;
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
