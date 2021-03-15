package com.cg.apps.customerms.ui;

import com.cg.apps.customerms.customer.service.*;
import com.cg.apps.customerms.items.entities.Item;
import com.cg.apps.customerms.items.service.IItemService;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.apps.customerms.customer.entities.*;

@Component
public class CustomerUi {
	@Autowired
	private ICustomerService service;

	@Autowired
	private IItemService iservice;

	public static void main(String args[]) {
		CustomerUi app = new CustomerUi();
		app.start();

	}

	public void start() {

		Customer cust1 = service.createCustomer("Yash");
		Customer cust2 = service.createCustomer("yash1");

		Item item1 = iservice.create(100.00, "Choclate");
		Item item2 = iservice.create(200.00, "Soft Drinks");
		Item item3 = iservice.create(50.00, "Chips");

		Item itemBought1 = iservice.buyItem(item1.getId(), cust1.getId());

		Item itemBought2 = iservice.buyItem(item2.getId(), cust2.getId());

		Item itemBought3 = iservice.buyItem(item3.getId(), cust1.getId());

		Set<Item> items1 = service.itemsBoughtByCustomer(cust1.getId());
		for (Item item : items1) {
			System.out.println(item.getDescription());
		}

		Set<Item> items2 = service.itemsBoughtByCustomer(cust2.getId());
		for (Item item : items2) {
			System.out.println(item.getDescription());
		}

		Customer addCust1 = service.addAmount(cust1.getId(), 4000);
		Customer addCust2 = service.addAmount(cust2.getId(), 4000);
		
		System.out.println("Item 1 id is "+item1.getId());

	}

}
