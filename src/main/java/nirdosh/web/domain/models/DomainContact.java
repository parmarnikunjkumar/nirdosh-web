package nirdosh.web.domain.models;

import nirdosh.web.validation.TelephoneValidation;

import org.hibernate.validator.constraints.NotEmpty;

public class DomainContact {
	
	@NotEmpty(message="{custom.message.firstname}")
	private String firstName;

	@NotEmpty(message="{custom.message.lastname}")
	private String lastName;
	
	@NotEmpty(message="{custom.message.email}")
	private String email;
	
	@NotEmpty(message="{custom.message.telephone}")
	@TelephoneValidation(message="{custom.message.telephone.length}")
	private String telephone;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
