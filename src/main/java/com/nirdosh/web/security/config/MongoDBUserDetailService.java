package com.nirdosh.web.security.config;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.nirdosh.dao.UserDAO;

public class MongoDBUserDetailService implements UserDetailsService{

	@Inject UserDAO userDAO;
	
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
