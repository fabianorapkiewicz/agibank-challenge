package com.ilegra.frapkiewicz.challenge.model;

import java.util.regex.Pattern;

public class Customer extends ReportData{
	private String id;
	private String cnpj;
	private String name;
	private String businessArea;
	
	public Customer() {
		
	}
	
	protected Customer(String[] elements) {
		setId(elements[0]);
		setCnpj(elements[1]);
		setName(elements[2]);
		setBusinessArea(elements[3]);
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBusinessArea() {
		return businessArea;
	}


	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}
	
	public static Customer from(String data) {
		String REGEX_CUSTUMER_ID = "002";
		String REGEX_DELIMITER = ReportData.REGEX_DELIMITER;
		String REGEX_CNPJ = "\\d{16}";
		String REGEX_NAME = "[A-Z][a-z]*";
		String REGEX_FULLNAME = "([A-Z][a-z]*)((\\s[a-z]{2})?(\\s[A-Z][a-z]*))*";
		String REGEX_BUSINESS_AREA = REGEX_NAME;

		
		String CUSTOMER_REGEX = 
				REGEX_CUSTUMER_ID + REGEX_DELIMITER + 
				REGEX_CNPJ + REGEX_DELIMITER + 
				REGEX_FULLNAME + REGEX_DELIMITER + 
				REGEX_BUSINESS_AREA;
		
		if(Pattern.compile(CUSTOMER_REGEX).matcher(data).matches()) {
			String[] elements = data.split(REGEX_DELIMITER);
			return new Customer(elements);
		}else {
			return null;
		}
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", cnpj=" + cnpj + ", name=" + name + ", businessArea=" + businessArea + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((businessArea == null) ? 0 : businessArea.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (businessArea == null) {
			if (other.businessArea != null)
				return false;
		} else if (!businessArea.equals(other.businessArea))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
