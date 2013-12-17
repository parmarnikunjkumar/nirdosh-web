package com.nirdosh.data.model;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.nirdosh.enums.CardType;

@Document
public class CustomerCard implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(CustomerCard.class);
	
	public CustomerCard(){
		
	}
	public CustomerCard(CardType cardType){
		this.cardType = cardType;
		this.balance = cardType.getPrice();
		this.entriesLeft = cardType.getNumber();
	}
	
	@Id
	private String id;
	
	CardType cardType;
	
	private int type;
	
	private int entriesLeft;
	
	private float balance;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getEntriesLeft() {
		return entriesLeft;
	}

	public void setEntriesLeft(int entriesLeft) {
		this.entriesLeft = entriesLeft;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}	
	
	public void deductOne(){
		entriesLeft --;
		balance = balance - cardType.getSinglePrice();
	}
	
	public boolean isCardValid(){
		LOGGER.debug("Balance:{}",balance);
		if(balance==0) {
			LOGGER.debug("Card is not Valid");
			return false;
		}
		LOGGER.debug("Card is still Valid");
		return true;
	}
	
}
