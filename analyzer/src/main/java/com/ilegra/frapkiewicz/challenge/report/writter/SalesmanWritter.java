package com.ilegra.frapkiewicz.challenge.report.writter;

import java.util.function.Consumer;

import com.ilegra.frapkiewicz.challenge.model.Salesman;
import com.ilegra.frapkiewicz.challenge.report.SalesReport;

public class SalesmanWritter extends ReportWritter{
	@Override
	protected Salesman getReportData(String rowData) {
		return Salesman.from(rowData);
	}

	@Override
	protected Consumer<Salesman> updateReport(SalesReport report) {
		return salesman -> report.add(salesman);
	}
}
