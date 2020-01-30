package com.ilegra.frapkiewicz.challenge;

import org.springframework.stereotype.Component;

@Component
public class SalesReportImp implements SalesReport {

	@Override
	public void addSalesman(String salesman) {
		System.out.println(salesman);
	}

	@Override
	public void addCustomer(String customer) {
		System.out.println(customer);
	}

	@Override
	public void addSale(String sale) {
		System.out.println(sale);
	}

}
