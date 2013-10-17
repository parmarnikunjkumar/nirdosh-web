package com.nirdosh.data.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nirdosh.data.model.Contact;

public interface ContactRepository extends MongoRepository<Contact, String>{
	
	public Contact findByFirstName(String firstName);
	
	public List<Contact> findByLastName(String lastName);

}
