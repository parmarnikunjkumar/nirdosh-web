package com.nirdosh.data.storage.service.mongodb.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.nirdosh.data.model.Contact;
import com.nirdosh.data.storage.service.ContactService;
import com.nirdosh.web.profile.Prod;

@Service
@Prod
public class ContactMongoDbService implements ContactService{

	@Inject private MongoTemplate mongoOperaions;
	
	public void put(String key, Contact value) {
		mongoOperaions.save(value);
		
	}

	public Contact get(String key) {
		return mongoOperaions.findById(key, Contact.class);
	}

	public void delete(String key) {
		mongoOperaions.remove(key);
		
	}

	public List<Contact> getAll() {
		return mongoOperaions.findAll(Contact.class);
	}

}
