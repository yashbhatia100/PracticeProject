package com.cg.apps.customerms.items.dao;

import com.cg.apps.customerms.items.entities.Item;

public interface IItemDao {
	 public Item add(Item item);
		public Item update(Item item);
		public Item findByID(String ItemID);

}

