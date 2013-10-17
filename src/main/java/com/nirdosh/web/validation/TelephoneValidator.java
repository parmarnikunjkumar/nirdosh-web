package com.nirdosh.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TelephoneValidator implements ConstraintValidator<TelephoneValidation, String>{

	public void initialize(TelephoneValidation constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.length()<10){
			
			return true;
		}
		System.out.println("its not 10 digit sorry!");
		return false;
	}

}
