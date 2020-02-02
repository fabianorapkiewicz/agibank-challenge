package com.ilegra.frapkiewicz.challenge.report.writter;

import com.ilegra.frapkiewicz.challenge.parser.SaleParser;
import com.ilegra.frapkiewicz.challenge.report.SalesReport;

public class SaleWritter implements ReportWritter{

	@Override
	public void update(SalesReport report, String rowData) {
		new SaleParser().tryParse(rowData).ifPresent( sale -> report.add(sale));
	}
}
