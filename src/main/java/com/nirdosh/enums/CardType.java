package com.nirdosh.enums;

public enum CardType {
	
	CARD10(10), CARD20(20), CARD5(5), PRIVATE(1);
	
	private int number;
	
	private CardType(int number){
		this.number = number;
	}
	
	public int getNumber(){
		return number;
		
	}

}
