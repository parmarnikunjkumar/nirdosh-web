package com.nirdosh.dao;

import com.nirdosh.web.security.config.User;

public interface UserDAO {
	
	User getUserByFirstName(String userName, String password);
	
	User getUserByFirstName(String userName);
	
	void addUser(User user);

}
