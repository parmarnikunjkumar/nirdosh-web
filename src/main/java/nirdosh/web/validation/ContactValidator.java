package nirdosh.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import nirdosh.web.domain.models.DomainContact;

public class ContactValidator implements ConstraintValidator<ContactValidation, DomainContact>{

	public void initialize(ContactValidation constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	public boolean isValid(DomainContact contact, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return true;
	}

}
