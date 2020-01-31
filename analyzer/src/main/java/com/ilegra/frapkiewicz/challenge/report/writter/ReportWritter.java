package com.ilegra.frapkiewicz.challenge.report.writter;

import java.util.Optional;
import java.util.function.Consumer;

import com.ilegra.frapkiewicz.challenge.model.Salesman;
import com.ilegra.frapkiewicz.challenge.report.SalesReport;

public abstract class ReportWritter {
	
	private SalesReport report;
	
	public ReportWritter(SalesReport report) {
		this.report = report;
	}
	
	public abstract void update(String rowData);
	
	public SalesReport getReport() {
		return report;
	}
	
	public void updateB(String rowData) {
		Optional.ofNullable(getReportData(rowData))
			.ifPresent(updateReportB(report));
	}

	protected abstract <T> T getReportData(String rowData);

	protected abstract <T> Consumer<T> updateReportB(SalesReport report);
}
