package com.cg.apps.customerms.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.apps.customerms.customer.entities.Account;

public interface IAccountRepository extends JpaRepository<Account, Long> {

}
