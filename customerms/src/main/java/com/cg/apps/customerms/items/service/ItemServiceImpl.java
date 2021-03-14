package com.cg.apps.customerms.items.service;

import java.time.LocalDateTime;
import java.util.*;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.customerms.customer.entities.Customer;
import com.cg.apps.customerms.customer.dao.*;
import com.cg.apps.customerms.items.dao.ItemDaoImpl;
import com.cg.apps.customerms.items.entities.*;


@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private ItemDaoImpl dao;
	@Autowired
	private CustomerDaoImpl cdao;

	@Transactional
	@Override
	public Item create(Double price, String description) {

		Item item = new Item(price, description);
		LocalDateTime addedTime = LocalDateTime.now();
		item.setAddedDate(addedTime);
		return dao.add(item);

	}

	@Override
	public Item findByID(String itemID) {
		Item item = dao.findByID(itemID);
		return item;
	}

	@Override
	public Item buyItem(String itemID, Long customerId) {
		Customer customer=cdao.findById(customerId);
		Item item=findByID(itemID);
		item.setBoughtBy(customer);
		Set<Item> Items=customer.getBoughtItems();
		if(Items==null) {
			Items=new HashSet<>();
			customer.setBoughtItems(Items);
			
		}
		Items.add(item);
		cdao.update(customer);
		

		return null;
	}

}
