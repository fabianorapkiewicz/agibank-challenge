package com.ilegra.frapkiewicz.challenge.report.writter;

import java.util.Optional;

import com.ilegra.frapkiewicz.challenge.model.Salesman;
import com.ilegra.frapkiewicz.challenge.report.SalesReport;

public class SalesmanWritter implements ReportWritter{

	@Override
	public void update(SalesReport report, String rowData) {
		Optional.ofNullable(Salesman.from(rowData))
		.ifPresent( saleman -> report.add(saleman));
	}
}
