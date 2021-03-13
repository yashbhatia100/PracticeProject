package com.cg.apps.customerms.items.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.apps.customerms.items.entities.*;

import com.cg.apps.customerms.items.service.IItemService;

@Component
public class ItemUi {
	@Autowired
	private IItemService itemservice;
	public static void main (String args[]) {
		ItemUi app= new ItemUi();
		app.start();
	}
	
	public void start() {
	Item item1 =itemservice.create(100.00, "Choclate");
	display(item1);
	
	Item item2 = itemservice.create(200.00,"Soft Drinks");
	display(item2);
	Item fetchedItem = itemservice.findByID(item1.getId());
	display(fetchedItem);
		
		
	}
	void display(Item item) {
		System.out.println(item.getId()+" "+item.getPrice()+" "+item.getDescription());
		
	}
	

}
