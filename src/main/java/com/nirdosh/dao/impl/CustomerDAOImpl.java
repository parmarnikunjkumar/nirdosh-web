package com.nirdosh.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.nirdosh.dao.CustomerDAO;
import com.nirdosh.data.model.Customer;

@Service
public class CustomerDAOImpl implements CustomerDAO{

	@Inject MongoOperations mongoOperations;
	
	public Customer get(String id) {
		return mongoOperations.findById(id, Customer.class);
	}

	public void put(Customer customer) {
		mongoOperations.save(customer);
		
	}

	public List<Customer> getAll() {
		return mongoOperations.findAll(Customer.class);
	}

	public void delete(String id) {
		mongoOperations.remove(mongoOperations.findById(id, Customer.class));
	
	}

}
