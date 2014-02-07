package com.nirdosh.dao.impl;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.nirdosh.dao.UserDAO;
import com.nirdosh.test.TestMongoDBBase;
import com.nirdosh.web.security.config.User;

public class UserDAOImplTest extends TestMongoDBBase{

	@Inject 
	private UserDAO userDAO;
	
	@Test
	public void testCreateUser(){
		
		User user = new User();
		user.setUsername("nirdosh");
		user.setPassword("imurs4ever");
		user.setRole(1);
		user.setFirstName("nikunjkumar");
		user.setLastName("parmar");
		
		
		assertNotNull(userDAO);
		
		userDAO.addUser(user);
	}

}
