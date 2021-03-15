package com.cg.apps.customerms.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.customerms.items.dto.ItemDetail;
import com.cg.apps.customerms.items.dto.ItemsBuyRequest;
import com.cg.apps.customerms.items.entities.Item;
import com.cg.apps.customerms.items.service.IItemService;
import com.cg.apps.customerms.items.util.ItemUtil;


@RequestMapping("/items")
@RestController
public class ItemController {

	@Autowired
	private IItemService service;

	@Autowired
	private ItemUtil util;

	@GetMapping("/findbyid/{Itemid}")
	public ItemDetail findById(@PathVariable String Itemid)
	{
		Item item = service.findByID(Itemid);
		ItemDetail details=util.toDetail(item);
		return details;
	}

	@PutMapping("/buyItem")
	public ItemDetail buyItem(@RequestBody ItemsBuyRequest request)
	{
		Item item=service.buyItem(request.getItemId(),request.getCustId());
		ItemDetail details=util.toDetail(item);
		return details;
	}

}