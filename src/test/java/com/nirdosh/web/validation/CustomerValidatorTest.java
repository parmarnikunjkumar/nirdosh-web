package com.nirdosh.web.validation;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;

public class CustomerValidatorTest  {
	
	public static Validator validator;
	
	@BeforeClass
	public static void setUp(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

//	@Test
//	public void testCustomerForAge(){
//		Customer customer = new Customer("nirdosh", 2);
//		Set<ConstraintViolation<Customer>> constraionViolations = validator.validate(customer);
//		assertEquals(2, constraionViolations.size());
//		for(ConstraintViolation<Customer> violation: constraionViolations){
//			System.out.println(violation.getMessage());
//		}
//		
//	}
//	
//	@Test
//	public void testCustomerForName(){
//		Customer customer = new Customer("nird", 25);
//		Set<ConstraintViolation<Customer>> constraionViolations = validator.validate(customer);
//		assertEquals(1, constraionViolations.size());
//		for(ConstraintViolation<Customer> violation: constraionViolations){
//			System.out.println(violation.getMessage());
//		}
//		
//	}
}
