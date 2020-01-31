package com.ilegra.frapkiewicz.challenge;

import java.util.regex.Pattern;

public abstract class SalesReportParser {
	
	protected static final String REGEX_DELIMITER = "ç";
	
	private SalesReport report;
	private Pattern pattern;
	
	public SalesReportParser(SalesReport report, final String regexToValidate) {
		this.report = report;
		pattern = Pattern.compile( regexToValidate );
	}
		
	protected abstract void parseAndRegisterReportData(String value);
	
	public void update(String data) {
		if(isValid(data))
			parseAndRegisterReportData(data);
	}
	
	protected SalesReport getReport() {
		return report;
	}
	
	public boolean isValid( String value ){
		return pattern.matcher( value ).matches();
	}
}
