package com.cg.apps.customerms.customer.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.apps.customerms.customer.entities.*;
@Repository
public class CustomerDaoImpl implements ICustomerDao {
	@PersistenceContext 
	private EntityManager entityManger;
	

	@Override
	public  void add(Customer customer) {
		entityManger.persist(customer);
	}

	@Override
	public Customer findById(Long customerId) {

	Customer customer=entityManger.find(Customer.class, customerId);
	return customer;
	}
@Transactional
	@Override
	public Customer update(Customer customer) {
		
	return	entityManger.merge(customer);

		
	}

}
