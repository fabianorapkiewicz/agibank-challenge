package com.ilegra.frapkiewicz.challenge;

public class SaleParser extends SalesReportParser {

	public SaleParser(SalesReport report) {
		super(report);
	}

	@Override
	public void update(String value) {
		if(value.startsWith("sale_"))
			getReport().addSale(value);
	}

}
