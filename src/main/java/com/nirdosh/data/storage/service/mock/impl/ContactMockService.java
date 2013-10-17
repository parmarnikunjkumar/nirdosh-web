package com.nirdosh.data.storage.service.mock.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.nirdosh.data.model.Contact;
import com.nirdosh.data.storage.service.ContactService;


@Service
public class ContactMockService implements ContactService{
	
	@Inject MockStorageService<Contact> storageService;

	public Contact get(String key) {
		return storageService.get(key);
	}

	public void put(String key, Contact contact) {
		if(key==null){
			key = contact.getFirstName();
		}
		storageService.put(key, contact);		
	}

	public void delete(String key) {
		storageService.delete(key);
		
	}

	public List<Contact> getAll() {
		return storageService.getAll();
	}
	
	

}
