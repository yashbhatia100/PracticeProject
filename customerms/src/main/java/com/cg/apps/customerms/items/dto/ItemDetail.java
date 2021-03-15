package com.cg.apps.customerms.items.dto;

public class ItemDetail {
	private String Itemid;
	private double price;
	private String description;
	private long custid;
	private String custname;
	
public ItemDetail() {
	
	}
	
	public ItemDetail(String itemid, double price, String description, Long custid, String custname) {
		this.Itemid = itemid;
		this.price = price;
		this.description = description;
		this.custid = custid;
		this.custname = custname;
	}
	public String getId() {
		return Itemid;
	}
	public void setId(String id) {
		this.Itemid = id;
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
	public long getCustid() {
		return custid;
	}
	public void setCustid(long custid) {
		this.custid = custid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	
	
	

}
