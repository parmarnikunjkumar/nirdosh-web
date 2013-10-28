package com.nirdosh.web.controller;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nirdosh.data.model.Customer;
import com.nirdosh.data.storage.service.StorageService;

@Controller
@RequestMapping("/rest/customer")
public class RestCustomerController {

	@Inject @Qualifier("customer") StorageService<String, Customer> customerStorageService;
	
	@Inject MongoTemplate mongoOperations;
	
	@RequestMapping("/all")
	@ResponseBody
	public List<Customer> getAllCustomer(){
		System.out.println("All request");
		return mongoOperations.findAll(Customer.class);
	}
	
	@RequestMapping("/{id}")
	@ResponseBody
	public Customer getCustomer(@PathVariable String id){
		return customerStorageService.get(id);
	}
	
	@RequestMapping("/{id}/entries/decrement")
	@ResponseBody
	public void decrementEntryCount(@PathVariable String id){
		Customer customer = customerStorageService.get(id);
		customer.setEntriesLeft(customer.getEntriesLeft()-1);
		customerStorageService.update(customer);
	}
	
	@RequestMapping("/{id}/entries/increment")
	@ResponseBody
	public void incrementEntryCount(@PathVariable String id){
		Customer customer = customerStorageService.get(id);
		customer.setEntriesLeft(customer.getEntriesLeft()+1);
		customerStorageService.update(customer);
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	@ResponseBody
	public void addCustomer(Customer customer){
		String key = UUID.randomUUID().toString();
		customerStorageService.put(key, customer);
	}
	
}
