package com.ilegra.frapkiewicz.challenge.model;

import java.util.regex.Pattern;

public class Salesman extends ReportData{
	private String id;
	private String cpf;
	private String name;
	private Double salary;
		
	public Salesman() {
		
	}
	
	protected Salesman(String[] elements) {
		setId(elements[0]);
		setCpf(elements[1]);
		setName(elements[2]);
		setSalary(Double.valueOf(elements[3]));
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public static Salesman from(String data) {
		String REGEX_SALESMAN_ID = "001";
		String REGEX_DELIMITER = ReportData.REGEX_DELIMITER;
		String REGEX_CPF = "\\d{13}";
		String REGEX_NAME = "[A-Z][a-z]*";
		String REGEX_SALARY = "\\d[0-9]*+(\\.[0-9]{2}+)?";
		
		String SALESMAN_REGEX = 
				REGEX_SALESMAN_ID + 
				REGEX_DELIMITER + 
				REGEX_CPF + REGEX_DELIMITER + 
				REGEX_NAME + REGEX_DELIMITER + 
				REGEX_SALARY;
		
		if(Pattern.compile(SALESMAN_REGEX).matcher(data).matches()) {
			String[] elements = data.split(REGEX_DELIMITER);
			return new Salesman(elements);
		}else {
			return null;
		}
	}

	@Override
	public String toString() {
		return "Salesman [id=" + id + ", cpf=" + cpf + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
}
