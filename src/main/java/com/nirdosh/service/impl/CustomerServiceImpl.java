package com.nirdosh.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.nirdosh.dao.CustomerDAO;
import com.nirdosh.data.model.Customer;
import com.nirdosh.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	@Inject CustomerDAO customerDAO;
	
	public void save(Customer customer) {
		customerDAO.put(customer);
		
	}

	public List<Customer> getAll() {
		return customerDAO.getAll();
	}

	public Customer getCustomerById(String id) {
		return customerDAO.get(id);
	}

	public void delete(String id) {
		customerDAO.delete(id);
		
	}

}
