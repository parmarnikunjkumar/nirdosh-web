package com.nirdosh.data.storage.service.mongodb.impl;

import java.io.Serializable;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.nirdosh.data.storage.service.StorageService;
import com.nirdosh.web.profile.Prod;

@Service
@Prod
public class MongoDBStorageService<T extends Serializable> implements StorageService<String, T>{

	@Inject
	MongoTemplate mongoOperations;
	
	public void put(String key, T value) {
		// TODO Auto-generated method stub
		
	}

	public T get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(String key) {
		// TODO Auto-generated method stub
		
	}

}
