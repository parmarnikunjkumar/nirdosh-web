package com.nirdosh.enums;

public enum CustomerField {
	
	FIRST_NAME("firstName"),
	LAST_NAME("lastName"),
	EMAIL("email"),
	MOBILE("mobile"),
	HOME("home"),
	BALANCE("balance");
	
	private String name;
	
	private CustomerField(String name){
		this.name = name;
	}
	
	public String get(){
		return name;
	}
	
}
