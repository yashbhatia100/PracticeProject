package com.cg.apps.customerms.items.util;

import org.springframework.stereotype.Component;


import com.cg.apps.customerms.items.dto.ItemDetail;
import com.cg.apps.customerms.items.entities.Item;

@Component
public class ItemUtil {
	public ItemDetail toDetail(Item item) {
		ItemDetail itemdetail = new ItemDetail(item.getId(),item.getPrice(),item.getDescription(),item.getBoughtBy().getId(), item.getBoughtBy().getName());
		
		return itemdetail;

	}

}
