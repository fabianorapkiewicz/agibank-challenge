package com.ilegra.frapkiewicz.challenge.report.writter;

import java.util.Optional;
import java.util.function.Consumer;

import com.ilegra.frapkiewicz.challenge.report.SalesReport;

public abstract class ReportWritter{
	
	private SalesReport report;

	public SalesReport getReport() {
		return report;
	}
	
	public void update(SalesReport report, String rowData) {
		Optional.ofNullable(getReportData(rowData))
			.ifPresent(updateReport(report));
	}

	protected abstract <T> T getReportData(String rowData);

	protected abstract <T> Consumer<T> updateReport(SalesReport report);
}
