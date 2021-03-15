package com.cg.apps.customerms.customer.util;

import org.springframework.stereotype.Component;

import com.cg.apps.customerms.customer.dto.CustomerDetail;
import com.cg.apps.customerms.customer.entities.Customer;

@Component
public class CustomerUtil {
	public CustomerDetail toDetail(Customer customer) {
		CustomerDetail custdetail=new CustomerDetail();
		custdetail.setId(customer.getId());
		custdetail.setName(customer.getName());
		custdetail.setAccountid(customer.getId());
		custdetail.setBalance(customer.getAccount().getBalance());
		return custdetail;
	}

}
