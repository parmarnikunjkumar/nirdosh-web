package com.nirdosh.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Transient;

public enum CardType {
	
	
	CARD10(10,135),
	CARD5(5,70);
	
	@Transient
	private static Logger LOGGER = LoggerFactory.getLogger(CardType.class);
	
	private int number;
	private double price;
	
	private CardType(int number, int price){
		this.number = number;
		this.price = price;
	}
	
	public int getNumber(){
		return number;		
	}
	
	public double getPrice(){
		return price;
	}
	
	public double getSinglePrice(){
		double result = price/number;
		LOGGER.debug("Result:{}",result);
		return result;
	}

}
