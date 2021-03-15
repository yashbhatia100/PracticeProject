package com.cg.apps.customerms.items.service;

import java.time.LocalDateTime;
import java.util.*;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.customerms.customer.entities.Customer;
import com.cg.apps.customerms.customer.dao.*;
import com.cg.apps.customerms.items.entities.*;

@Service
public class ItemServiceImpl implements IItemService {

	
	public String generateString() {
		String str="Item";
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<3;i++) {
		Random random=new Random();
		int generateid=random.nextInt(9);
		builder.append(generateid);
		}
		String itemid=builder.toString();
		return str+itemid;
		
	}
	
	@Autowired
	private IItemRepository irepository;
	@Autowired
	private ICustomerRepository crepository;

	@Transactional 
	@Override
	public Item create(Double price, String description) {

		Item item = new Item(price, description);
		LocalDateTime addedTime = LocalDateTime.now();
		item.setAddedDate(addedTime);
		
		String id=generateString();
		item.setId(id);
		return irepository.save(item);

	}

	@Override
	public Item findByID(String itemID) {
		Optional<Item> item = irepository.findById(itemID);
		return item.get();
	}

	@Transactional
	@Override
	public Item buyItem(String itemID, Long customerId) {
		Optional<Customer> customer = crepository.findById(customerId);
		Item item = findByID(itemID);
		
		
		item.setBoughtBy(customer.get());
		
		irepository.save(item);
		crepository.save(customer.get());

		return item;
	}

}
