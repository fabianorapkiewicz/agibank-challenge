package com.ilegra.frapkiewicz.challenge.parser;

import java.util.Optional;
import java.util.regex.Pattern;

import com.ilegra.frapkiewicz.challenge.model.ReportData;

public abstract class ReportDataParser <T extends ReportData> {
	
	protected static final String REGEX_DELIMITER = "ç";
	private Pattern pattern;
	
	public ReportDataParser(final String regexToValidate) {
		pattern = Pattern.compile( regexToValidate );
	}
	
	protected abstract T parse(String value);
	
	public  Optional<T> tryParse(String value){
		if(canParse(value))
			return Optional.of(parse(value));
		else
			return Optional.empty();
	}
	
	protected boolean canParse( String value ){
		return pattern.matcher( value ).matches();
	}
}
