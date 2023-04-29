package com.codewave.demo.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewave.demo.model.TransferRecord;
import com.codewave.demo.repository.TransferRecordRepository;
import com.codewave.demo.service.TransferService;

//Business Logic
@Service
public class TransferServiceImpl implements TransferService {

  // String name;
  @Autowired
  TransferRecordRepository transferRecordRepository;

  @Override
  public List<TransferRecord> getTransferRecords() {
    TransferRecord record1 = TransferRecord.createTransferRecord(123, 456, 3000);
    TransferRecord record2 = TransferRecord.createTransferRecord(123, 456, 6000);
    return Arrays.asList(record1, record2);
    // return new ArrayList<>()
  }

  // For MYSQL JPA
  public TransferRecord findTransferRecordById(Long id) {
    return transferRecordRepository.findById(id).orElse(null);
  }

}
