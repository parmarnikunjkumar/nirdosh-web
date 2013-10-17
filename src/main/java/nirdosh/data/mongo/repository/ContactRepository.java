package nirdosh.data.mongo.repository;

import java.util.List;

import nirdosh.data.model.Contact;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String>{
	
	public Contact findByFirstName(String firstName);
	
	public List<Contact> findByLastName(String lastName);

}
