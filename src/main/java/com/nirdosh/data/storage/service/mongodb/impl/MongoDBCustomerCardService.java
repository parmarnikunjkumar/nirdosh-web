package com.nirdosh.data.storage.service.mongodb.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nirdosh.data.model.CustomerCard;
@Service
@Qualifier("customerCard")
public class MongoDBCustomerCardService extends MongoDBService<CustomerCard>{

	private static final String COLLECTION_NAME = "customer_cards";
	
	public void put(String key, CustomerCard customerCard) {
		customerCard.setId(key);
		mongoOperations.save(customerCard,COLLECTION_NAME);		
	}

	public CustomerCard get(String key) {
		return mongoOperations.findById(key, CustomerCard.class,COLLECTION_NAME);
	}

	public void delete(String key) {
		mongoOperations.remove(get(key), COLLECTION_NAME);		
	}

	public List<CustomerCard> getAll() {
		return mongoOperations.findAll(CustomerCard.class, COLLECTION_NAME);
	}

	public void update(CustomerCard value) {
		// TODO Auto-generated method stub
		
	}

}
