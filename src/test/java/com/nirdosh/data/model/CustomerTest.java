package com.nirdosh.data.model;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.AssertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import static org.junit.Assert.*;

import com.mongodb.Mongo;

public class CustomerTest {

	private MongoTemplate mongoOperations;
	
	
	@Before
	public void createCustomerWithAddress() throws UnknownHostException{
		
		mongoOperations = new MongoTemplate(new Mongo("localhost"), "nirdoshdbtest");
		 mongoOperations.dropCollection(Customer.class);
		 mongoOperations.dropCollection(PaymentInfo.class);
		 mongoOperations.dropCollection(Address.class);
		
		PaymentInfo payment = new PaymentInfo();
		payment.setAmountPaid("150");
		payment.setCurrency("Euro");
		mongoOperations.save(payment);
		
		
		Address address = new Address();
		
		address.setCountry("germany");
		address.setHouseNumber("10");
		address.setStreetName("im Tal");
		address.setPlz("14532");
		address.setState("Brandenburg");
		
		mongoOperations.save(address);
		
		List<Address> addressList = new ArrayList<Address>();
		addressList.add(address);
		
		Customer customer = new Customer();
		customer.setAddresses(addressList);
		customer.setFirstName("test");
		customer.setPaymentInfo(payment);
		
		mongoOperations.save(customer);
	}
	
	@Test	
	public void checkCustomerAndAddress(){
		Query query = new Query();
		Criteria criteria = new Criteria();
		query.addCriteria(criteria.where("firstName").is("test"));
		
		Customer customer = mongoOperations.findOne(query,Customer.class);
		assertEquals("im Tal", customer.getAddresses().get(0).getStreetName());
		assertEquals("150", customer.getPaymentInfo().getAmountPaid());
		
	}

}
