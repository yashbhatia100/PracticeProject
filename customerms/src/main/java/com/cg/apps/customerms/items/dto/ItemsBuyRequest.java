package com.cg.apps.customerms.items.dto;

public class ItemsBuyRequest {
	private String itemId;
	private long custId;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

}
