package com.nirdosh.enums;

public enum CardType {
	
	CARD10(10,135);
	
	private int number;
	private int price;
	
	private CardType(int number, int price){
		this.number = number;
		this.price = price;
	}
	
	public int getNumber(){
		return number;		
	}
	
	public int getPrice(){
		return price;
	}
	
	public float getSinglePrice(){
		return price/number;
	}

}
