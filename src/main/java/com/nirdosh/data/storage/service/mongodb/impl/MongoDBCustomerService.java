package com.nirdosh.data.storage.service.mongodb.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.nirdosh.data.model.Customer;
import com.nirdosh.web.profile.Prod;

@Prod
@Service
public class MongoDBCustomerService extends MongoDBService<Customer>{	
	
	private static final String COLLECTION_NAME = "customers";

	public void put(String key, Customer customer) {
		if(!mongoOperations.collectionExists(Customer.class)){
			mongoOperations.createCollection(Customer.class);
		}
		customer.setCustomerID(UUID.randomUUID().toString());
		mongoOperations.save(customer,COLLECTION_NAME);
		
	}

	public Customer get(String key) {
		return mongoOperations.findById(key, Customer.class);
	}

	public void delete(String key) {
		mongoOperations.remove(get(key));
		
	}

	public List<Customer> getAll() {
		return mongoOperations.findAll(Customer.class, COLLECTION_NAME);
	}


}
