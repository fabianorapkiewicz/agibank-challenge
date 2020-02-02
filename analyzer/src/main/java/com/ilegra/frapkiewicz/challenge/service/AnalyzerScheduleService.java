package com.ilegra.frapkiewicz.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ilegra.frapkiewicz.challenge.report.SalesReport;
import com.ilegra.frapkiewicz.challenge.repository.Repository;


@Component
@EnableScheduling
public class AnalyzerScheduleService {

	private static final long FIVE_SECONDS = 5000;

	@Autowired
	private Analyzer analyzer;
	
	@Autowired
	private Repository repository;
	
	@Scheduled(fixedDelay = FIVE_SECONDS)
	public void run() {
		System.out.println("INICIO DE CLICO");
		
		List<String> rowsOfFile = repository.getSalesData();
		
		SalesReport report = analyzer.analyze(rowsOfFile);
		
		if(report.hasResults())
			repository.save(report.getResults());
		
		System.out.println("FIM DE CLICO");
	}
}
