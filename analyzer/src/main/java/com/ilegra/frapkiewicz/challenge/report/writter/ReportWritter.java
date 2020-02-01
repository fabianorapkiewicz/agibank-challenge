package com.ilegra.frapkiewicz.challenge.report.writter;

import com.ilegra.frapkiewicz.challenge.report.SalesReport;

public interface ReportWritter {
	
	public void update(SalesReport report, String rowData);
}
