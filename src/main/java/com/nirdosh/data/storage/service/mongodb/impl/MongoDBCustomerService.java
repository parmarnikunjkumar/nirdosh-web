package com.nirdosh.data.storage.service.mongodb.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nirdosh.data.model.Customer;
import com.nirdosh.web.profile.Prod;

@Prod
@Service
@Qualifier("customer")
public class MongoDBCustomerService extends MongoDBService<Customer>{	
	
	private static final String COLLECTION_NAME = "customers";

	public void put(String key, Customer customer) {
		customer.setId(UUID.randomUUID().toString());
		mongoOperations.save(customer,COLLECTION_NAME);
		
	}

	public Customer get(String key) {
		return mongoOperations.findById(key,Customer.class,COLLECTION_NAME);
	}

	public void delete(String key) {
		mongoOperations.remove(get(key),COLLECTION_NAME);
		
	}

	public List<Customer> getAll() {
		return mongoOperations.findAll(Customer.class, COLLECTION_NAME);
	}

	public void update(Customer value) {
		
		mongoOperations.insert(value,COLLECTION_NAME);
		
	}


}
