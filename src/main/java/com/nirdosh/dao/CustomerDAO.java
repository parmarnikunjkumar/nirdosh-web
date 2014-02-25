package com.nirdosh.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.nirdosh.data.model.Customer;

public interface CustomerDAO {
	
	Customer get(String id);
	
	void put(Customer customer);
	
	List<Customer> getAll();
	
	void delete(String id);
	
	void update(Query query, Update update);

	List<Customer> get(List<String> ids);
	
}
