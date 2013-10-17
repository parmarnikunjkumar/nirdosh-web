package com.nirdosh.data.mongo.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.nirdosh.data.model.Contact;
import com.nirdosh.data.storage.service.DbServices;

@Repository
public class MongoContactDbServices implements DbServices<String, Contact> {

	@Inject
	MongoTemplate mongoOperations;

	public boolean put(String key, Contact value) {
		mongoOperations.save(value);
		return true;
	}

	public Contact get(String key) {
		return mongoOperations.findById(key, Contact.class);

	}

	public boolean delete(String key) {
		mongoOperations.remove(mongoOperations.findById(key, Contact.class));
		return true;
	}

	public List<Contact> getAll() {
		return mongoOperations.findAll(Contact.class);
	}

	public void put(Contact value) {
		mongoOperations.save(value);
		
	}

	public void update(Contact value) {
		mongoOperations.insert(value);
		
	}

	public void deleteByFirstName(String firstName) {
		
		
	}

}
