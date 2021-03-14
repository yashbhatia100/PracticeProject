package com.cg.apps.customerms.customer.service;

import java.util.*;
import com.cg.apps.customerms.items.entities.*;

import com.cg.apps.customerms.customer.entities.*;

public interface ICustomerService {
	Customer findById(Long customerId);
	Set<Item> itemsBoughtByCustomer(Long customerID);
	Customer createCustomer(String name);
	Customer addAmount(Long customerId,double amount);

}
