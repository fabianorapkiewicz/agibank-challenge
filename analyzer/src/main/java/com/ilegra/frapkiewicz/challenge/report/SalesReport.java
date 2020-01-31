package com.ilegra.frapkiewicz.challenge.report;

import com.ilegra.frapkiewicz.challenge.model.Customer;
import com.ilegra.frapkiewicz.challenge.model.Sale;
import com.ilegra.frapkiewicz.challenge.model.Salesman;

public interface SalesReport {
	
	public void add(Salesman data);
	public void add(Customer data);
	public void add(Sale data);
	public String getResume();
	public boolean hasContent();
}
