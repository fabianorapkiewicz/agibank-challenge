package com.ilegra.frapkiewicz.challenge.parser;

import com.ilegra.frapkiewicz.challenge.model.Customer;
import com.ilegra.frapkiewicz.challenge.model.ReportData;
import com.ilegra.frapkiewicz.challenge.report.SalesReport;

public class CustomerParser extends SalesReportParser {

	private static final String REGEX_CUSTUMER_ID = "002";
	private static final String REGEX_DELIMITER = "ç";
	private static final String REGEX_CNPJ = "\\d{16}";
	private static final String REGEX_NAME = "[A-Z][a-z]*";
	private static final String REGEX_FULLNAME = "([A-Z][a-z]*)((\\s[a-z]{2})?(\\s[A-Z][a-z]*))*";
	private static final String REGEX_BUSINESS_AREA = REGEX_NAME;

	
	private static final String CUSTOMER_REGEX = 
			REGEX_CUSTUMER_ID + REGEX_DELIMITER + 
			REGEX_CNPJ + REGEX_DELIMITER + 
			REGEX_FULLNAME + REGEX_DELIMITER + 
			REGEX_BUSINESS_AREA;


	
	public CustomerParser(SalesReport report) {
		super(CUSTOMER_REGEX);
	}

	@Override
	protected ReportData parse(String data) {
		String[] elements = data.split(REGEX_DELIMITER);
		
		Customer customer = new Customer();
		customer.setId(elements[0]);
		customer.setCnpj(elements[1]);
		customer.setName(elements[2]);
		customer.setBusinessArea(elements[3]);
		
		return customer;
	}

}