package com.ilegra.frapkiewicz.challenge.report.writter;

import java.util.Optional;

import com.ilegra.frapkiewicz.challenge.model.Customer;
import com.ilegra.frapkiewicz.challenge.report.SalesReport;

public class CustomerWritter implements ReportWritter{

	@Override
	public void update(SalesReport report, String rowData) {
		Optional.ofNullable(Customer.from(rowData))
		.ifPresent( customer -> report.add(customer));
	}
}
