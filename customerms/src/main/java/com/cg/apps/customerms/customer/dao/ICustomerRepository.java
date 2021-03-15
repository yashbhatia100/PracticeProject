package com.cg.apps.customerms.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.apps.customerms.customer.entities.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

}
