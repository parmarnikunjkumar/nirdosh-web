package com.nirdosh.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringValidator implements ConstraintValidator<StringValidate, String> {

	public void initialize(StringValidate constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}
