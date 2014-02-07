package com.nirdosh.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.nirdosh.enums.CardType;


public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String firstName;

	private String lastName;

	private String email;

	private List<Telephone> telephones;
	
	private String mobile;
	
	private String home;	
	
	private List<Address> addresses;
	
	private List<String> courseList;
	
	private CustomerCard customerCard;
	
	private double balance;
	
	private List<Payment> paymentHistory;
	
	private boolean isSatsangi;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}	

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}		

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}
	
	public List<String> getCourseList() {
		if(courseList== null){
			courseList = new ArrayList<String>();
		}
		return courseList;
	}

	public void setCourseList(List<String> courseList) {
		this.courseList = courseList;
	}	

	public CustomerCard getCustomerCard() {
		if(customerCard== null) customerCard = new CustomerCard();
		return customerCard;
	}

	public void setCustomerCard(CustomerCard customerCard) {
		this.customerCard = customerCard;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}	
	
	public List<Payment> getPaymentHistory() {
		if(paymentHistory == null){
			paymentHistory = new ArrayList<Payment>();
		}
		return paymentHistory;
	}

	public void setPaymentHistory(List<Payment> paymentHistory) {
		this.paymentHistory = paymentHistory;
	}

	/**
	 * Return total balance a customer can have
	 * @return totalBalance
	 */
	public double getTotalBalance(){
		return balance + getCustomerCard().getBalance();
	}	

	public boolean isSatsangi() {
		return isSatsangi;
	}

	public void setSatsangi(boolean isSatsangi) {
		this.isSatsangi = isSatsangi;
	}

	@Override
	public String toString() {
		return String.format(
				"Customer[customerID=%s firstName='%s' lastName='%s' Balance='%s']", id,
				firstName, lastName,balance);
	}

}
