package com.ilegra.frapkiewicz.challenge;

public class CustomerParser extends SalesReportParser {

	public CustomerParser(SalesReport report) {
		super(report);
	}

	@Override
	public void update(String value) {
		if(value.startsWith("customer"))
			getReport().addCustomer(value);
	}

}
