package com.cg.apps.customerms.items.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.cg.apps.customerms.customer.entities.Customer;
@Entity
public class Item {
	@Id
	private String id;
	double price;
	String description;
	@ManyToOne
	Customer boughtBy;
	public Customer getBoughtBy() {
		return boughtBy;
	}

	public void setBoughtBy(Customer boughtBy) {
		this.boughtBy = boughtBy;
	}

	public Item() {
		
	}

	public Item(double price, String description) {

		this.price = price;
		this.description = description;
	}

	
	LocalDateTime addedDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public LocalDateTime getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDateTime addedDate) {
		this.addedDate = addedDate;
	}

}
