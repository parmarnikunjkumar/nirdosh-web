package com.nirdosh.test;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.nirdosh.dao.UserDAO;
import com.nirdosh.dao.impl.UserDAOImpl;

@Configuration
public class TestMongoDBConfig {
	
	@Bean
	MongoOperations mongoOperations() throws UnknownHostException{
		MongoTemplate mongoOperations = new MongoTemplate(new Mongo("localhost"), "nirdoshdb");
		return mongoOperations;
	}

	@Bean
	UserDAO userDAO(){
		return new UserDAOImpl();
	}
}
