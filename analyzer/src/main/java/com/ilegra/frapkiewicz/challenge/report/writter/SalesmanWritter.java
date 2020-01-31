package com.ilegra.frapkiewicz.challenge.report.writter;

import java.util.Optional;
import java.util.function.Consumer;

import com.ilegra.frapkiewicz.challenge.model.Salesman;
import com.ilegra.frapkiewicz.challenge.report.SalesReport;

public class SalesmanWritter extends ReportWritter{
	
	public SalesmanWritter(SalesReport report) {
		super(report);
	}

	public void update(String rowData) {
		Optional.ofNullable(Salesman.from(rowData))
			.ifPresent(updateReport(getReport()));
	}

	public Consumer<Salesman> updateReport(SalesReport report){
		return salesman -> report.add(salesman);
	}

	@Override
	protected Salesman getReportData(String rowData) {
		return Salesman.from(rowData);
	}

	@Override
	protected Consumer<Salesman> updateReportB(SalesReport report) {
		return salesman -> report.add(salesman);
	}
}
