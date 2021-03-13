package com.cg.apps.customerms.customer.service;

import com.cg.apps.customerms.customer.entities.*;

public interface ICustomerService {
	Customer findById(Long customerId);

	Customer createCustomer(String name);
	Customer addAmount(Long customerId,double amount);

}
