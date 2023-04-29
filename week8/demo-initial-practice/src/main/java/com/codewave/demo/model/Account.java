package com.codewave.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
// @Table(name = "ACCOUNT") // -> convension over configuration
public class Account {

  @Id //
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String email; // new add

  private List<TransferRecord> transferRecords;

}
