package com.nirdosh.dao.impl;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.nirdosh.dao.UserDAO;
import com.nirdosh.web.security.config.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Inject MongoOperations mongoOperations;
	
	
	public User getUserByFirstName(String userName, String password) {
		User user = mongoOperations.findOne(new Query(Criteria.where("username").is(userName).and("password").is(password)), User.class);
		return user;
	}


	public User getUserByFirstName(String userName) {
		User user = mongoOperations.findOne(new Query(Criteria.where("username").is(userName)), User.class);
		return user;
	}

}
