package com.somesh.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.somesh.banking.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
