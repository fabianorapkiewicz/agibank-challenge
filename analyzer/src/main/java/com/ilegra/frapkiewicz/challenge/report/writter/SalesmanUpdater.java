package com.ilegra.frapkiewicz.challenge.report.writter;

import com.ilegra.frapkiewicz.challenge.parser.SalesmanParser;
import com.ilegra.frapkiewicz.challenge.report.SalesReport;

public class SalesmanUpdater implements ReportUpdater{

	@Override
	public void updateReport(SalesReport report, String rowData) {
		new SalesmanParser().tryParse(rowData)
		.ifPresent( sale -> report.add(sale));
	}
}
