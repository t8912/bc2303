package com.codewave.demo.repository;

//import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewave.demo.model.TransferRecord;

@Repository
public interface TransferRecordRepository extends JpaRepository<TransferRecord, Long> {
  // empty
}
