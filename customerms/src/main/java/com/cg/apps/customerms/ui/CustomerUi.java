package com.cg.apps.customerms.ui;

import com.cg.apps.customerms.customer.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.apps.customerms.customer.entities.*;
@Component
public class CustomerUi {
	@Autowired
	private ICustomerService service;
	
	public static void main (String args[])
	{
		CustomerUi app=new CustomerUi();
		app.start();
		
	}
	public void start() {
		
		Customer cust1 = service.createCustomer("Yash");
		Customer cust2 = service.createCustomer("yash1");
		Customer fetchedCustomer=service.findById(cust2.getId());
		display(fetchedCustomer);
		display(cust1);
		
		
		
	}
	public void display(Customer customer) {
		System.out.println(customer.getId()+" "+customer.getName());
		
	}

}
