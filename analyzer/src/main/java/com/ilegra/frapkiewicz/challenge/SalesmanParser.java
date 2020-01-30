package com.ilegra.frapkiewicz.challenge;

public class SalesmanParser extends SalesReportParser {

	public SalesmanParser(SalesReport report) {
		super(report);
	}
	
	@Override
	public void update(String value) {
		if(value.startsWith("sales-man"))
			getReport().addSalesman(value);
	}
}
