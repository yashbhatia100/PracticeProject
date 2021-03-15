package com.cg.apps.customerms.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.apps.customerms.customer.dto.*;
import com.cg.apps.customerms.customer.service.ICustomerService;
import com.cg.apps.customerms.customer.util.CustomerUtil;

@RequestMapping("/customer")
@RestController
public class CustomerController {
	@Autowired
	private ICustomerService service;

	@Autowired
	private CustomerUtil util;

	@PostMapping("/add")
	public CustomerDetail addNewCustomer(@RequestBody CreateCustomerRequest request) {
		return util.toDetail(service.createCustomer(request.getName()));
	}

	@GetMapping("/findbyid/{id}")
	public CustomerDetail findById(@PathVariable long id) {
		return util.toDetail(service.findById(id));
	}

	@PutMapping("/account/amount")
	public CustomerDetail addAmount(@RequestBody AddAmountRequest request) {
		return util.toDetail(service.addAmount(request.getId(), request.getBalance()));
	}

}
