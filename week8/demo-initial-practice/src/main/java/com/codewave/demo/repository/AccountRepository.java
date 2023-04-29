package com.codewave.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewave.demo.model.Account;

// ORM: Object Relation MApping
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
