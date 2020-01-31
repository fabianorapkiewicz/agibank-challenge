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
	
	
}
