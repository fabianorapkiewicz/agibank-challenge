package com.ilegra.frapkiewicz.challenge.report.writter;

import java.util.Optional;
import java.util.function.Consumer;

import com.ilegra.frapkiewicz.challenge.model.Customer;
import com.ilegra.frapkiewicz.challenge.report.SalesReport;

public class CustomerWritter extends ReportWritter{
	
	public CustomerWritter(SalesReport report) {
		super(report);
	}

	public void update(String rowData) {
		Optional.ofNullable(Customer.from(rowData))
			.ifPresent( customer -> getReport().add(customer) );
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
