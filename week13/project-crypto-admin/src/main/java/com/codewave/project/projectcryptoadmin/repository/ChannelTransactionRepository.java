package com.codewave.project.projectcryptoadmin.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewave.project.projectcryptoadmin.model.entity.ChannelTransaction;

import java.util.List;


public interface ChannelTransactionRepository extends JpaRepository<ChannelTransaction, Long> {

    List<ChannelTransaction> findBySourceAndTranType(String source, String tranType);
}


/* 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewave.project.projectcryptoadmin.model.entity.ChannelTransaction;

import java.util.List;

@Repository
public interface ChannelTransactionRepository extends JpaRepository<ChannelTransaction, Long> {

    List<ChannelTransaction> findBySourceAndTranType(String source, String tranType);
}
*/
