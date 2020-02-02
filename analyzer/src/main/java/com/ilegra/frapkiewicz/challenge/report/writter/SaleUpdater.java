package com.ilegra.frapkiewicz.challenge.report.writter;

import com.ilegra.frapkiewicz.challenge.parser.SaleParser;
import com.ilegra.frapkiewicz.challenge.report.SalesReport;

public class SaleUpdater implements ReportUpdater{

	@Override
	public void updateReport(SalesReport report, String rowData) {
		new SaleParser().tryParse(rowData).ifPresent( sale -> report.add(sale));
	}
}
