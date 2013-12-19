package com.nirdosh.data.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Payment implements Serializable{
	
	private Date date;
	
	private double amount;
	
	public Payment(){
		
	}

	public Payment(Date date, double amount){
		this.date = date;
		this.amount = amount;
	}	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}	
}
