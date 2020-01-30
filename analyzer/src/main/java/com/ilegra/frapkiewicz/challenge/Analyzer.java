package com.ilegra.frapkiewicz.challenge;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Analyzer {
	
	private SalesReport report;

	private List<SalesReportParser> parserList;
	
	@Autowired
	public Analyzer(SalesReport report) {
		this.report = report;
		parserList = new ArrayList<SalesReportParser>();
		attach(new SalesmanParser(report));
		attach(new CustomerParser(report));
		attach(new SaleParser(report));
	}
	
	public void attach(SalesReportParser parser) {
		parserList.add(parser);		
	}
	
	public void dettach(SalesReportParser parser) {
		parserList.remove(parser);		
	}
	
	public void setEvent(String event) {
		notifyAllParsers(event);
	}
	
	public void notifyAllParsers(String event) {
		parserList.stream()
			.parallel()
			.forEach( parser -> {
				parser.update(event);
			});
	}
}
