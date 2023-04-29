package com.codewave.demo.service;

import java.util.List;

import com.codewave.demo.model.TransferRecord;

public interface TransferService {

  List<TransferRecord> getTransferRecords();

  TransferRecord findTransferRecordById(Long id);

}
