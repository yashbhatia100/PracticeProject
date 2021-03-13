package com.cg.apps.customerms.items.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;

import com.cg.apps.customerms.items.entities.Item;
@Repository
public class ItemDaoImpl implements IItemDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	public String generateString() {
		String str="Item";
		str=str+Math.random();
		return str;
	}
	
@Transactional
	@Override
	public Item add(Item item) {
		String id=generateString();
		item.setId(id);
		entityManager.persist(item);
		
		return item;
	}

	@Override
	public Item update(Item item) {
		
		
		return null;
	}

	@Override
	public Item findByID(String ItemID) {
		Item item = entityManager.find(Item.class,ItemID);
		return item;
	}
	
	

}
