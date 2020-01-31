package com.ilegra.frapkiewicz.challenge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
public class AnalyzerScheduleService {

	private static final long FIVE_SECONDS = 5000;

	@Autowired
	private Analyzer analyzer;
	
	@Scheduled(fixedDelay = FIVE_SECONDS)
	public void run() {
		System.out.println("INICIO DE CLICO");
		
		List<String> events = new ArrayList<String>();
		events.add("sales-man");
		events.add("customer");
		events.add("sale_");
		events.forEach(processEvents(analyzer));
		
		System.out.println("FIM DE CLICO");
	}
	
	public Consumer<String> processEvents(Analyzer analyzer){
		return event -> analyzer.setEvent(event);
	}
}
