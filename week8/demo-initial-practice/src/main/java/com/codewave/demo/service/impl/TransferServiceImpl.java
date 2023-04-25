package com.codewave.demo.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codewave.demo.model.TransferRecord;

@Service
public class TransferServiceImpl implements TransferService{

  // String name;
  
  @Override
  public List<TransferRecord> getTransferRecords() {
    TransferRecord record1 = TransferRecord.createTransferRecord(123, 456, 3000);
    TransferRecord record2 = TransferRecord.createTransferRecord(123, 456, 6000);
    return Arrays.asList(record1, record2);
    //return new ArrayList<>()
  }
  
}