package com.whitelist.taxpayers.model;

import javax.validation.constraints.NotEmpty;

public class Form {

	@NotEmpty(message = "Proszę podać sposób wyszukiwania!")
	private String searchMethod;

	@NotEmpty(message = "Proszę podać numer!")
	private String number;

	public String getSearchMethod() {
		return searchMethod;
	}

	public void setSearchMethod(String searchMethod) {
		this.searchMethod = searchMethod;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
