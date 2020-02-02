package com.ilegra.frapkiewicz.challenge.report.writter;

import com.ilegra.frapkiewicz.challenge.report.SalesReport;

public interface ReportUpdater {
	
	public void updateReport(SalesReport report, String rowData);
}
