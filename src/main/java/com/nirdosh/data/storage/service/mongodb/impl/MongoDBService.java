package com.nirdosh.data.storage.service.mongodb.impl;

import java.io.Serializable;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.nirdosh.data.storage.service.StorageService;

public abstract class MongoDBService<T extends Serializable> implements StorageService<String, T>{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MongoDBService.class);
	
	@Inject
	protected MongoTemplate mongoOperations;
	
}
