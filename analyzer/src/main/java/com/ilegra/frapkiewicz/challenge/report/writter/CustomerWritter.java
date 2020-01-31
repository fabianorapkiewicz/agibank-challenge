package com.ilegra.frapkiewicz.challenge.report.writter;

import java.util.Optional;
import java.util.function.Consumer;

import com.ilegra.frapkiewicz.challenge.model.Customer;
import com.ilegra.frapkiewicz.challenge.model.Salesman;
import com.ilegra.frapkiewicz.challenge.report.SalesReport;

public class CustomerWritter extends ReportWritter{
	
//	public CustomerWritter(SalesReport report) {
//		super(report);
//	}
//
//	public void update(String rowData) {
//		Optional.ofNullable(Customer.from(rowData))
//			.ifPresent( customer -> getReport().add(customer) );
//	}

	@Override
	protected Customer getReportData(String rowData) {
		return Customer.from(rowData);
	}

	@Override
	protected Consumer<Customer> updateReport(SalesReport report) {
		return customer -> report.add(customer);
	}
}
