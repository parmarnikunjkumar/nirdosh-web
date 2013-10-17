package com.nirdosh.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nirdosh.web.domain.models.Customer;

@Component
@Scope
public class CustomerValidator implements ConstraintValidator<CustomerValidation, Customer>{

	public void initialize(CustomerValidation constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	public boolean isValid(Customer customer, ConstraintValidatorContext context) {
		if(customer.getAge() < 5){
			return false;
		}
		
		if(customer.getName().length() < 5){
			return false;
		}
		return true;
	}

}
