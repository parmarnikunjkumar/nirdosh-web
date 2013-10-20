package com.nirdosh.data.model;

import com.nirdosh.enums.TelephoneType;

public class Telephone {

	private String number;
	
	private TelephoneType telephoneType;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public TelephoneType getTelephoneType() {
		return telephoneType;
	}

	public void setTelephoneType(TelephoneType telephoneType) {
		this.telephoneType = telephoneType;
	}
	
	
}
