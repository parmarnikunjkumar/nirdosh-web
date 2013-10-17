package nirdosh.web.domain.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import nirdosh.web.validation.CustomerValidation;

import org.hibernate.validator.constraints.NotEmpty;

@CustomerValidation(message="not valid")
public class Customer {

	@NotEmpty @Size(max=15)
	private String name;
	
	@Max(50) @Min(18)
	int age;

	public Customer(){
		
	};
	
	public Customer(String name, int age){
		this.name= name;
		this.age = age;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
