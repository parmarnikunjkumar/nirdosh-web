package com.nirdosh.dao;

import java.util.List;

import com.nirdosh.data.model.Customer;

public interface CustomerDAO {
	
	Customer get(String id);
	
	void put(Customer customer);
	
	List<Customer> getAll();
	
	void delete(String id);
	
}
