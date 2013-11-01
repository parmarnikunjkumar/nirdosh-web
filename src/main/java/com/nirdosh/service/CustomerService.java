package com.nirdosh.service;

import java.util.List;

import com.nirdosh.data.model.Customer;

public interface CustomerService {
	
	void save(Customer customer);
	
	List<Customer> getAll();
	
	Customer getCustomerById(String id);
	
	void delete(String id);
}
