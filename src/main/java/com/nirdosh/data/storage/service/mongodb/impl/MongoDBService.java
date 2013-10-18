package com.nirdosh.data.storage.service.mongodb.impl;

import java.io.Serializable;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.nirdosh.data.storage.service.StorageService;

public abstract class MongoDBService<T extends Serializable> implements StorageService<String, T>{
	
	@Inject MongoTemplate mongoOperations;
	
}
