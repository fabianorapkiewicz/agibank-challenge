package com.ilegra.frapkiewicz.challenge.report.writter;

import com.ilegra.frapkiewicz.challenge.parser.SalesmanParser;
import com.ilegra.frapkiewicz.challenge.report.SalesReport;

public class SalesmanWritter implements ReportWritter{

	@Override
	public void update(SalesReport report, String rowData) {
		new SalesmanParser().tryParse(rowData)
		.ifPresent( sale -> report.add(sale));
	}
}
