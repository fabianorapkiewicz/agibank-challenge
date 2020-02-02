package com.ilegra.frapkiewicz.challenge.parser;

import java.util.regex.Pattern;

import com.ilegra.frapkiewicz.challenge.model.ReportData;

public abstract class ReportDataParser <T extends ReportData> {
	
	protected static final String REGEX_DELIMITER = "ç";
	private Pattern pattern;
	
	public ReportDataParser(final String regexToValidate) {
		pattern = Pattern.compile( regexToValidate );
	}
		
	public abstract T parse(String value);
	
	public boolean isValid( String value ){
		return pattern.matcher( value ).matches();
	}
}
