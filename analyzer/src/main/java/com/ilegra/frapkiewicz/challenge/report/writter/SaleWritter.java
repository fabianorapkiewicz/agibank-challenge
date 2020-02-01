package com.ilegra.frapkiewicz.challenge.report.writter;

import java.util.Optional;

import com.ilegra.frapkiewicz.challenge.model.Sale;
import com.ilegra.frapkiewicz.challenge.report.SalesReport;

public class SaleWritter implements ReportWritter{

	@Override
	public void update(SalesReport report, String rowData) {
		Optional.ofNullable(Sale.from(rowData))
		.ifPresent( sale -> report.add(sale));
	}
}
