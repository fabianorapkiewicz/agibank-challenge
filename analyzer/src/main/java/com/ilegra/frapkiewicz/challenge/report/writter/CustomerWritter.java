package com.ilegra.frapkiewicz.challenge.report.writter;

import com.ilegra.frapkiewicz.challenge.parser.CustomerParser;
import com.ilegra.frapkiewicz.challenge.report.SalesReport;

public class CustomerWritter implements ReportWritter{

	@Override
	public void update(SalesReport report, String rowData) {
		CustomerParser parser = new CustomerParser();
		if( parser.isValid(rowData) )
			report.add(parser.parse(rowData));		
	}
}
