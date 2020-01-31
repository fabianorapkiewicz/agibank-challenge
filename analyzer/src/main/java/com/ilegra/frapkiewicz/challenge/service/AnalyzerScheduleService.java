package com.ilegra.frapkiewicz.challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ilegra.frapkiewicz.challenge.report.SalesReport;


@Component
@EnableScheduling
public class AnalyzerScheduleService {

	private static final long FIVE_SECONDS = 5000;

	@Autowired
	private Analyzer analyzer;
	
	@Scheduled(fixedDelay = FIVE_SECONDS)
	public void run() {
		System.out.println("INICIO DE CLICO");
		
		List<String> rowsOfFile = daoRead();
		
		SalesReport report = analyzer.analyze(rowsOfFile);
		
		if(report.hasContent())
			daoWrite(report);
		
		System.out.println("FIM DE CLICO");
	}
	
	private void daoWrite(SalesReport report) {
		System.out.println("-------------RELATÓRIO--------------");
		System.out.println(report.getResume());
		System.out.println("------------------------------------");
	}

	private List<String> daoRead(){
		List<String> rowsOfFile = new ArrayList<String>();
		rowsOfFile.add("001ç1234567891234çPedroç50000");
		rowsOfFile.add("001ç3245678865434çPauloç40000.99");
		rowsOfFile.add("002ç2345675434544345çJose da SilvaçRural");
		rowsOfFile.add("002ç2345675433444345çEduardo PereiraçRural");
		rowsOfFile.add("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro");
		
		rowsOfFile.add("003ç07ç[1-34-10,2-33-1.40,3-40-0.10]çMateus");
		
		rowsOfFile.add("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo");
		return rowsOfFile;
	}
}
