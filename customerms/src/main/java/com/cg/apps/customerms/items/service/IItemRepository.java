package com.cg.apps.customerms.items.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.apps.customerms.items.entities.Item;

public interface IItemRepository extends JpaRepository<Item, String> {

}
