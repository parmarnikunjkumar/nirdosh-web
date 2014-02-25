package com.nirdosh.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.nirdosh.dao.CustomerDAO;
import com.nirdosh.data.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Inject MongoOperations mongoOperations;
	
	public Customer get(String id) {
		return mongoOperations.findById(id, Customer.class);
	}

	public void put(Customer customer) {
		mongoOperations.save(customer);		
	}

	public List<Customer> getAll() {
		return mongoOperations.findAll(Customer.class);
	}

	public void delete(String id) {
		mongoOperations.remove(mongoOperations.findById(id, Customer.class));	
	}

	public void update(Query query, Update update) {
		mongoOperations.updateFirst(query, update, Customer.class);		
	}

	public List<Customer> get(List<String> ids) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").in(ids));
		
		return mongoOperations.find(query, Customer.class);
	}
	

}
