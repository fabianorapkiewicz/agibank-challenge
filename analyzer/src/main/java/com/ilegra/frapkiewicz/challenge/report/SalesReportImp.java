package com.ilegra.frapkiewicz.challenge.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ilegra.frapkiewicz.challenge.model.Customer;
import com.ilegra.frapkiewicz.challenge.model.Sale;
import com.ilegra.frapkiewicz.challenge.model.Salesman;

@Component
public class SalesReportImp implements SalesReport {

	private List<Salesman> salesmanList;
	private List<Customer> customerList;
	private List<Sale> saleList;
	
	
	public SalesReportImp() {
		salesmanList = new ArrayList<Salesman>();
		customerList = new ArrayList<Customer>();
		saleList = new ArrayList<Sale>();
	}
	
	@Override
	public boolean hasContent() {
		return !(salesmanList.isEmpty() && customerList.isEmpty() && saleList.isEmpty());
	}
	
	@Override
	public void add(Salesman salesman) {
		salesmanList.add(salesman);
	}

	@Override
	public void add(Customer customer) {
		customerList.add(customer);
	}

	@Override
	public void add(Sale sale) {
		saleList.add(sale);
	}
	
	@Override
	public String getResume() {
		
		
		
		return "";
	}

	@Override
	public String toString() {
		return "SalesReportImp [salesmanList=" + salesmanList + ", customerList=" + customerList + ", saleList="
				+ saleList + "]";
	}
}
