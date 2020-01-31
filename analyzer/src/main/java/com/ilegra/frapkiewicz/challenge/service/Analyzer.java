package com.ilegra.frapkiewicz.challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ilegra.frapkiewicz.challenge.report.SalesReport;
import com.ilegra.frapkiewicz.challenge.report.SalesReportImp;
import com.ilegra.frapkiewicz.challenge.report.writter.CustomerWritter;
import com.ilegra.frapkiewicz.challenge.report.writter.ReportWritter;
import com.ilegra.frapkiewicz.challenge.report.writter.SaleWritter;
import com.ilegra.frapkiewicz.challenge.report.writter.SalesmanWritter;

@Component
public class Analyzer {
	
	private List<ReportWritter> witterList;
	
	public Analyzer() {
		witterList = new ArrayList<ReportWritter>();
		attach(new SalesmanWritter());
		attach(new CustomerWritter());
		attach(new SaleWritter());
	}
	
	public void attach(ReportWritter writter) {
		witterList.add(writter);		
	}
	
	public void dettach(ReportWritter writter) {
		witterList.remove(writter);		
	}
	
	public SalesReport analyze(List<String> rowsOfFile) {
		SalesReport report = new SalesReportImp();
		rowsOfFile.forEach( row -> notifyAllWritters(row, report) );
		return report;
	}
	
	public void notifyAllWritters(String event, SalesReport report) {
		witterList.stream()
			.parallel()
			.forEach( writter -> {
				writter.update(report, event);
			});
	}
}
