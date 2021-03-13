package com.cg.apps.customerms.items.service;

import com.cg.apps.customerms.items.entities.Item;

public interface IItemService {
	Item create (Double price,String description);
	Item findByID(String itemID);
	Item buyItem(String itemID,Long customerId);

}
