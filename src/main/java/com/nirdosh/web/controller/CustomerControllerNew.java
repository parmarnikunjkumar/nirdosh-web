package com.nirdosh.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nirdosh.web.forms.CustomerForm;

@Controller
@RequestMapping("/customernew")
public class CustomerControllerNew {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerControllerNew.class);
	
	@RequestMapping(value = "/addCustomer", method=RequestMethod.POST)
	public String addCustomer(@ModelAttribute("contact") CustomerForm customerForm, BindingResult result) {
		LOGGER.debug("FirstName:{}",customerForm.getFirstName());
		
		return "welcom";
	}

}
