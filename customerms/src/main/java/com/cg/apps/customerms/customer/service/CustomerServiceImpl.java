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
import com.cg.apps.customerms.customer.exceptions.CustomerNotFoundException;
import com.cg.apps.customerms.items.entities.Item;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerRepository crepository;
	@Autowired
	private IAccountRepository arepository;

	@Transactional
	@Override
	public Customer createCustomer(String name) {

		LocalDateTime currentTime = LocalDateTime.now();
		Account account = new Account(40000, currentTime);

		arepository.save(account);
		Customer customer = new Customer(name, account);

		customer = crepository.save(customer);
		return customer;

	}

	@Override
	public Customer findById(Long customerId) {
		Optional<Customer> optional = crepository.findById(customerId);
		if (!optional.isPresent()) {
			throw new CustomerNotFoundException("Student not Found for this id");
		}

		return optional.get();
	}

	@Transactional
	@Override
	public Customer addAmount(Long customerId, double amount) {

		Customer customer = findById(customerId);
		Account account = customer.getAccount();
		account.setBalance(amount);
		arepository.save(account);
		crepository.save(customer);
		return customer;
	}

	@Override
	public Set<Item> itemsBoughtByCustomer(Long customerID) {
		Optional<Customer> customer = crepository.findById(customerID);
		if (!customer.isPresent()) {
			throw new CustomerNotFoundException("Customer is not present with this id");
		}
		Customer cust = customer.get();
		Set<Item> items = cust.getBoughtItems();
		return items;
	}

}
