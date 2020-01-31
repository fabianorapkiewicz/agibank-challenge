package com.ilegra.frapkiewicz.challenge.report;

import org.springframework.stereotype.Component;

import com.ilegra.frapkiewicz.challenge.model.Customer;
import com.ilegra.frapkiewicz.challenge.model.Sale;
import com.ilegra.frapkiewicz.challenge.model.Salesman;

@Component
public class SalesReportImp implements SalesReport {

	@Override
	public void add(Salesman salesman) {
		System.out.println(salesman);
	}

	@Override
	public void add(Customer customer) {
		System.out.println(customer);
	}

	@Override
	public void add(Sale sale) {
		System.out.println(sale);
	}

}
