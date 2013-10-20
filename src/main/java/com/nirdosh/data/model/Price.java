package com.nirdosh.data.model;

import com.nirdosh.enums.CardType;

public class Price {
	
	private double value;
	
	private CardType cardType;

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
