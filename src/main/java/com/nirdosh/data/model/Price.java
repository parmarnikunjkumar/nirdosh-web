package com.nirdosh.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.nirdosh.enums.CardType;

@Document
public class Price {
	
	@Id
	private String id;
	
	private double value;
	
	private CardType cardType;
	
		public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}
	

}
