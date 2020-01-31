package com.ilegra.frapkiewicz.challenge;

public class SalesmanParser extends SalesReportParser {

	private static final String REGEX_SALESMAN_ID = "001";
	private static final String REGEX_CPF = "\\d{13}";
	private static final String REGEX_NAME = "[A-Z][a-z]*";
	private static final String REGEX_SALARY = "\\d[0-9]*+(\\.[0-9]{2}+)?";
	
	private static final String SALESMAN_REGEX = 
			REGEX_SALESMAN_ID + 
			REGEX_DELIMITER + 
			REGEX_CPF + REGEX_DELIMITER + 
			REGEX_NAME + REGEX_DELIMITER + 
			REGEX_SALARY;
	
	public SalesmanParser(SalesReport report) {
		super(report, SALESMAN_REGEX);
	}
	
	@Override
	protected void parseAndRegisterReportData(String data) {
		String[] elements = data.split(REGEX_DELIMITER);
		
		Salesman salesman = new Salesman();
		salesman.setId(elements[0]);
		salesman.setCpf(elements[1]);
		salesman.setName(elements[2]);
		salesman.setSalary(Double.valueOf(elements[3]));
		
		getReport().add(salesman);
	}
}
