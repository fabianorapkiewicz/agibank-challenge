package com.ilegra.frapkiewicz.challenge.report.writter;

import java.util.Optional;
import java.util.function.Consumer;

import com.ilegra.frapkiewicz.challenge.model.Sale;
import com.ilegra.frapkiewicz.challenge.report.SalesReport;

public class SaleWritter extends ReportWritter{
	
	public SaleWritter(SalesReport report) {
		super(report);
	}

	public void update(String rowData) {
		Optional.ofNullable(Sale.from(rowData))
			.ifPresent( sale -> getReport().add(sale) );
	}

	@Override
	protected <T> T getReportData(String rowData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected <T> Consumer<T> updateReportB(SalesReport report) {
		// TODO Auto-generated method stub
		return null;
	}
}
