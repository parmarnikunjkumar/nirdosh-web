package com.nirdosh.web.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nirdosh.data.model.Contact;
import com.nirdosh.data.storage.service.ContactService;
import com.nirdosh.web.domain.models.Customer;
import com.nirdosh.web.domain.models.DomainContact;

@Controller
public class MainController {
	
	@Inject private ContactService contactService;
	
	@RequestMapping(value = "/{customer}", method = RequestMethod.GET)
	public @ResponseBody
	String getData(@PathVariable @Valid Customer customer) {

		return customer.getName() + customer.getAge();
	}

	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContact(@Valid DomainContact domainContact, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("result", result);
			return "contact";
		} else {
			saveContctToDb(domainContact);
			return "showContact";
		}

	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String showContacts(DomainContact domainContact, ModelMap model) {
		model.addAttribute("contactList",contactService.getAll());
		model.addAttribute("domainContact",new DomainContact());
		return "contact";
	}

	@RequestMapping("/hello")
	public ModelAndView helloWorld() {
		String message = "Hellow World, Spring 3.0.1!";
		return new ModelAndView("hello", "message", message);
	}
	
	@RequestMapping("/delete")
	public String deleteContact(String id){
		contactService.delete(id);
		return "Delete";
	}

	// -- business methods

	private void validate(@Valid Customer customer) {

	}

	private void saveContctToDb(DomainContact domainContact) {
		
		Contact contact = new Contact();
		contact.setFirstName(domainContact.getFirstName());
		contact.setLastName(domainContact.getLastName());
		contact.setEmail(domainContact.getEmail());
		
		contactService.put(contact.getId(), contact);
	}
}