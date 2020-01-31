package com.ilegra.frapkiewicz.challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ilegra.frapkiewicz.challenge.report.SalesReport;
import com.ilegra.frapkiewicz.challenge.report.SalesReportImp;
import com.ilegra.frapkiewicz.challenge.report.writter.CustomerWritter;
import com.ilegra.frapkiewicz.challenge.report.writter.ReportWritter;
import com.ilegra.frapkiewicz.challenge.report.writter.SaleWritter;
import com.ilegra.frapkiewicz.challenge.report.writter.SalesmanWritter;

@Component
public class Analyzer {
	
	private SalesReport report;

	private List<ReportWritter> witterList;
	
	public Analyzer() {
		report = new SalesReportImp();
		witterList = new ArrayList<ReportWritter>();
		attach(new SalesmanWritter(report));
		attach(new CustomerWritter(report));
		attach(new SaleWritter(report));
	}
	
	public void attach(ReportWritter writter) {
		witterList.add(writter);		
	}
	
	public void dettach(ReportWritter writter) {
		witterList.remove(writter);		
	}
	
	public void setEvent(String event) {
		notifyAllWritters(event);
	}
	
	public void notifyAllWritters(String event) {
		witterList.stream()
			.parallel()
			.forEach( writter -> {
				writter.update(event);
			});
	}
	
	public SalesReport getReport() {
		return report;
	}
}
