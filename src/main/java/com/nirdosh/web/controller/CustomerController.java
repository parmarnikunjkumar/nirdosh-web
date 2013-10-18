package com.nirdosh.web.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nirdosh.data.model.Customer;
import com.nirdosh.data.storage.service.StorageService;

@Controller
public class CustomerController {
	
	@Inject StorageService<String, Customer> customerStorageService;
	
	@RequestMapping(value="/customer",method= RequestMethod.GET)
	public String getCustomer(HttpServletRequest request, Model model){
		Customer customer
		return null;
	}

}
