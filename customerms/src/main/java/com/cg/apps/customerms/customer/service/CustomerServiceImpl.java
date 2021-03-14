package com.cg.apps.customerms.customer.service;

import java.time.LocalDateTime;
import java.util.*;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.customerms.customer.dao.*;
import com.cg.apps.customerms.customer.entities.Account;
import com.cg.apps.customerms.customer.entities.Customer;
import com.cg.apps.customerms.items.entities.Item;
@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	private ICustomerDao dao;
	@Autowired
	private EntityManager entityManger;
	
	
	@Transactional
	@Override
	public Customer createCustomer(String name) {
		
		
		LocalDateTime currentTime= LocalDateTime.now();
		Account account1=new Account(40000, currentTime);
		
		entityManger.persist(account1);
		Customer customer=new Customer(name,account1);
		
		dao.add(customer);
		return customer;
		
	}
	

	@Override
	public Customer findById(Long customerId) {
		Customer customer=dao.findById(customerId);
		return customer;
		
	}
	

	@Transactional
	@Override
	public Customer addAmount(Long customerId, double amount) {
		
		Customer customer=findById(customerId);
		Account account=customer.getAccount();
		account.setBalance(amount);
		entityManger.merge(account);
		dao.update(customer);
		return customer;
	}


	@Override
	public Set<Item> itemsBoughtByCustomer(Long customerID) {
		Customer customer=findById(customerID);
		Set<Item> items=customer.getBoughtItems();	
		return items;
	}
	
}
