package com.nirdosh.service;

import java.util.List;

import com.nirdosh.data.model.Customer;
import com.nirdosh.data.model.CustomerCard;
import com.nirdosh.data.model.TrainningCourse;
import com.nirdosh.enums.CardType;
import com.nirdosh.enums.CourseType;

public interface CustomerService {
	
	void save(Customer customer);
	
	List<Customer> getAll();
	
	Customer getCustomerById(String id);
	
	void delete(String id);
	
	void updateBalance(String id, double amount);
	
	void updateCard(String id, CardType cardType);
	
	void attendCourse(String id, TrainningCourse course);
}
