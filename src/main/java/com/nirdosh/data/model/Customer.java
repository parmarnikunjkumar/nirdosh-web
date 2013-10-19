package com.nirdosh.data.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


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

	private String telephone;

	private String customerCardType;
	
	private int entriesLeft;
	
	@DBRef
	private List<Address> addresses;
	
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCustomerCardType() {
		return customerCardType;
	}

	public void setCustomerCardType(String customerCardType) {
		this.customerCardType = customerCardType;
	}	

	public int getEntriesLeft() {
		return entriesLeft;
	}

	public void setEntriesLeft(int entriesLeft) {
		this.entriesLeft = entriesLeft;
	}	

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return String.format(
				"Customer[customerID=%s firstName='%s' lastName='%s']", id,
				firstName, lastName);
	}

}
