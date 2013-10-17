package com.nirdosh.data.storage.service;

import java.util.List;

import com.nirdosh.data.model.Contact;

public interface ContactService {
	
	Contact get(String key);
	
	void put(String key, Contact contact);
	
	void delete(String key);
	
	List<Contact> getAll();

}
