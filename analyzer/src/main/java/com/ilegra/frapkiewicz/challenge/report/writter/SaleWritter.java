package com.ilegra.frapkiewicz.challenge.report.writter;

import java.util.function.Consumer;

import com.ilegra.frapkiewicz.challenge.model.Sale;
import com.ilegra.frapkiewicz.challenge.report.SalesReport;

public class SaleWritter extends ReportWritter{

	@Override
	protected Sale getReportData(String rowData) {
		return Sale.from(rowData);
	}

	@Override
	protected Consumer<Sale> updateReport(SalesReport report) {
		return sale -> report.add(sale);
	}
}
