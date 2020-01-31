package com.ilegra.frapkiewicz.challenge;

import org.springframework.stereotype.Component;

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
