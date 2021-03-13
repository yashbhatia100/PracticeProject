package com.cg.apps.customerms.items.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.customerms.items.dao.ItemDaoImpl;
import com.cg.apps.customerms.items.entities.*;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private ItemDaoImpl dao;

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

		return null;
	}

}
