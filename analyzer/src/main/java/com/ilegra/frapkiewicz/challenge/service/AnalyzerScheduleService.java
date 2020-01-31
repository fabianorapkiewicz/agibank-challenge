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
		events.add("001ç1234567891234çPedroç50000");
		events.add("002ç2345675434544345çJose da SilvaçRural");
		events.add("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro");
		
		events.forEach(processEvents(analyzer));
		
		System.out.println("-------------RELATÓRIO--------------");
		System.out.println(analyzer.getReport());
		System.out.println("------------------------------------");
		
		System.out.println("FIM DE CLICO");
	}
	
	public Consumer<String> processEvents(Analyzer analyzer){
		return event -> analyzer.setEvent(event);
	}
}
