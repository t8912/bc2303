package com.codewave.demo.controller.impl;

//import java.math.BigDecimal;
//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.codewave.demo.controller.HelloworldOperations;
import com.codewave.demo.foundation.response.ApiResponse;
import com.codewave.demo.model.TransferRecord;
import com.codewave.demo.service.impl.TransferService;
import com.codewave.demo.service.impl.TransferServiceImpl;
//import com.codewave.demo.service.impl.TransferServiceimpl;
//import com.codewave.demo.service.impl.TransferServiceimpl;

//import lombok.Builder.ObtainVia;

@Controller
@ResponseBody
@RequestMapping(value = "/demo/practice/api/v1")
public class HelloworldController implements HelloworldOperations {

  @Autowired
  //TransferServiceimpl transferServiceimpl; //
  //TransferServiceImpl transferServiceImpl;
  TransferService transferService; // polymohipm decupling ??


  @Override
  public String sayHello() {
    return "Hello World";
  }

  @Override
  public ResponseEntity< ApiResponse<List<TransferRecord>>> getTransferRecords() {
    //   TransferServiceImpl TransferServiceImpl = new TransferServiceImpl();
    List<TransferRecord> result = transferService.getTransferRecords();
    
    if (result.size() == 0) {
      return ResponseEntity.notFound().build();
    }

    ApiResponse<List<TransferRecord>> response = ApiResponse.<List<TransferRecord>>builder()//
    .success()
    .data(result)
    .build();
    return ResponseEntity.ok().body(response);

  }
}

    //TransferRecord record1 = TransferRecord.createTransferRecord(123, 456, 3000);
    //TransferRecord record2 = TransferRecord.createTransferRecord(123, 456, 6000);
    //return Stream.of(record1, record2).collect(Collectors.toCollection());
   // return ApiResponse.<List<TransferRecord>>builder() //
      //.code(200)
      //.success(true)
      //.message("SUCCESS")
    //  .success()
    //  .data(transferService.getTransferRecords())
      //.data(transferServiceImpl.getTransferRecords())
      //.data(Stream.of(record1, record2).collect(Collectors.toList()))
    //  .build();
    

 // }
//}

// List<TransferRecord> transferRecords = new ArrayList<>();

// transferRecords.add(new TransferRecord("John Doe", "Alice Smith", new
// BigDecimal("100.00")));
// transferRecords.add(new TransferRecord("Bob Johnson", "Charlie Brown", new
// BigDecimal("50.00")));
// transferRecords.add(new TransferRecord("David Lee", "Emily Chen", new
// BigDecimal("200.00")));
// return transferRecords;

// List<TransferRecord> transferRecords = new ArrayList<>();
// Here you can add your code to retrieve the transfer records from a database
// or other data source
// For example:
/*
 * transferRecords.add(TransferRecord.builder()
 * .fromAccount(12345)
 * .fromEntry(Entry.DEBIT)
 * .toAccount(67890)
 * .toEntry(Entry.CREDIT)
 * .amount(new BigDecimal("100.00"))
 * .build());
 * transferRecords.add(TransferRecord.builder()
 * .fromAccount(23456)
 * .fromEntry(Entry.CREDIT)
 * .toAccount(78901)
 * .toEntry(Entry.DEBIT)
 * .amount(new BigDecimal("50.00"))
 * .build());
 * return transferRecords;
 * 
 */

// }
// }

// }

// }
