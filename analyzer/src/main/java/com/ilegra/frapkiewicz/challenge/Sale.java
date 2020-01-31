package com.ilegra.frapkiewicz.challenge;

import java.util.ArrayList;
import java.util.List;

public class Sale {
	private String id;
	private Long saleId;
	private List<SaleItem> saleItems;
	private String salesname;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Sale() {
		saleItems = new ArrayList<SaleItem>();
	}

	public Long getSaleId() {
		return saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}

	public List<SaleItem> getSaleItems() {
		return saleItems;
	}

	public void setSaleItems(List<SaleItem> saleItems) {
		this.saleItems = saleItems;
	}

	public String getSalesname() {
		return salesname;
	}

	public void setSalesname(String salesname) {
		this.salesname = salesname;
	}
}
