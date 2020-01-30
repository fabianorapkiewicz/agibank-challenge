package com.ilegra.frapkiewicz.challenge;

public abstract class SalesReportParser {
	
	private SalesReport report;
	
	public SalesReportParser(SalesReport report) {
		this.report = report;
	}
	
	public abstract void update(String value);
	
	protected SalesReport getReport() {
		return report;
	}
}
