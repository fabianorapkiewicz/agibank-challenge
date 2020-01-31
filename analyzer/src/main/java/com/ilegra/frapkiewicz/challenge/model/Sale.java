package com.ilegra.frapkiewicz.challenge.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Sale extends ReportData{
	private String id;
	private Long saleId;
	private List<SaleItem> saleItems;
	private String salesname;
	
	public Sale() {
		saleItems = new ArrayList<SaleItem>();	
	}
	
	public Sale(String[] elements) {
		setId(elements[0]);
		setSaleId(Long.valueOf(elements[1]));
		setSaleItems(parseSaleItems(elements[2]));
		setSalesname(elements[3]);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public Double getSalesValue() {
		return saleItems.stream()
				.map(SaleItem::getTotalSalesValue)
				.reduce(0.0, Double::sum); 
	}
	
	public static Sale from(String data) {
		String REGEX_SALES_ID = "003";
		String REGEX_SALE_ID = "\\d{2}";
		String REGEX_DELIMITER = ReportData.REGEX_DELIMITER;
		String REGEX_NAME = "[A-Z][a-z]*";
		String REGEX_SALARY = "\\d[0-9]*+(\\.[0-9]{2}+)?";
		String REGEX_ITEM = "\\d[0-9]*\\-\\d[0-9]*\\-"+ REGEX_SALARY;
		String REGEX_LIST_ITEM = "\\["+ REGEX_ITEM +"(,"+ REGEX_ITEM +")*\\]";

		String SALE_REGEX = 
				REGEX_SALES_ID + REGEX_DELIMITER +
				REGEX_SALE_ID + REGEX_DELIMITER +
				REGEX_LIST_ITEM + REGEX_DELIMITER +
				REGEX_NAME;
		
		if(Pattern.compile(SALE_REGEX).matcher(data).matches()) {
			String[] elements = data.split(REGEX_DELIMITER);
			return new Sale(elements);
		}else {
			return null;
		}
	}
	
	private List<SaleItem> parseSaleItems(String data) {
		String itemConcated = data.substring(1, data.length()-1);
		String[] items = itemConcated.split(",");
		
		List<SaleItem> saleItemList = new ArrayList<SaleItem>();
		
		for(String item : items)
			saleItemList.add(SaleItem.from(item));
		
		return saleItemList;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", saleId=" + saleId + ", saleItems=" + saleItems + ", salesname=" + salesname + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((saleId == null) ? 0 : saleId.hashCode());
		result = prime * result + ((saleItems == null) ? 0 : saleItems.hashCode());
		result = prime * result + ((salesname == null) ? 0 : salesname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (saleId == null) {
			if (other.saleId != null)
				return false;
		} else if (!saleId.equals(other.saleId))
			return false;
		if (saleItems == null) {
			if (other.saleItems != null)
				return false;
		} else if (!saleItems.equals(other.saleItems))
			return false;
		if (salesname == null) {
			if (other.salesname != null)
				return false;
		} else if (!salesname.equals(other.salesname))
			return false;
		return true;
	}
}
