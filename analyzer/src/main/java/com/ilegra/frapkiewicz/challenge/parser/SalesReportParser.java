package com.ilegra.frapkiewicz.challenge.parser;

import java.util.regex.Pattern;

import com.ilegra.frapkiewicz.challenge.model.ReportData;

public abstract class SalesReportParser {
	
	protected static final String REGEX_DELIMITER = "ç";
	private Pattern pattern;
	
	public SalesReportParser(final String regexToValidate) {
		pattern = Pattern.compile( regexToValidate );
	}
		
	protected abstract ReportData parse(String value);
	
	public boolean isValid( String value ){
		return pattern.matcher( value ).matches();
	}
}
