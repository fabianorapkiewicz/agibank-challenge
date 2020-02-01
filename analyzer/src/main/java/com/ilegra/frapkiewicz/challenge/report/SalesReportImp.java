package com.ilegra.frapkiewicz.challenge.report;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ilegra.frapkiewicz.challenge.model.Customer;
import com.ilegra.frapkiewicz.challenge.model.Sale;
import com.ilegra.frapkiewicz.challenge.model.Salesman;

@Component
public class SalesReportImp implements SalesReport {

	private String name;
	private List<Salesman> salesmanList;
	private List<Customer> customerList;
	private List<Sale> saleList;
	
	
	public SalesReportImp() {
		name = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		salesmanList = new ArrayList<Salesman>();
		customerList = new ArrayList<Customer>();
		saleList = new ArrayList<Sale>();
	}
	
	@Override
	public String getName() {
		return name;
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
		
		Integer numberOfSalesman = salesmanList.size();
		Integer numberOfCustomer = customerList.size();
		
		Sale mostExpensiveSale = saleList.stream()
				.sorted(Comparator.comparing(Sale::getSalesValue)
						.reversed())
				.collect(Collectors.toList())
				.stream()
				.findFirst()
				.get();
				
		Entry<String, Long> worstSalesman = saleList.stream()
				.collect(Collectors.groupingBy(Sale::getSalesname , Collectors.counting()))
				.entrySet()
				.stream()
				.findFirst()
				.get();
			    
				
		return "Quantidade de clientes no arquivo de entrada: " + numberOfCustomer + "\n"
				+ "Quantidade de vendedores no arquivo de entrada: " + numberOfSalesman + "\n"
				+ "ID da venda mais cara: " + mostExpensiveSale.getSaleId() + "\n"
				+ "O pior vendedor: " + worstSalesman.getKey();
	}

	@Override
	public String toString() {
		return "SalesReportImp [salesmanList=" + salesmanList + ", customerList=" + customerList + ", saleList="
				+ saleList + "]";
	}
}
