package com.nirdosh.web.security.config;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nirdosh.dao.UserDAO;

@Service
public class MongoDBUserDetailService implements UserDetailsService{
	
	private final static Logger LOGGER = LoggerFactory.getLogger(MongoDBUserDetailService.class);

	@Inject UserDAO userDAO;
	
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		User user = userDAO.getUserByFirstName(userName);
		
		LOGGER.debug("User Called :{}", user.getUsername());
		
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),true,true,true,true,getAuthorities(user.getRole()));
		return userDetails;
	}
	
	public List<GrantedAuthority> getAuthorities(Integer role){
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		if(role.intValue() == 1){
			authList.add(new SimpleGrantedAuthority("ROLE_USER"));
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}else if(role.intValue() == 2){
			authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		return authList;
	}

	
}
