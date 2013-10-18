package com.nirdosh.web.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nirdosh.data.model.Customer;
import com.nirdosh.data.storage.service.StorageService;

@Controller
public class CustomerController {
	
	@Inject StorageService<String, Customer> customerStorageService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@RequestMapping(value="/customer",method= RequestMethod.GET)
	public String getCustomer(HttpServletRequest request, Model model){
		
		model.addAttribute("customer", new Customer());
		model.addAttribute("customerList", customerStorageService.getAll());
		
		return "customer";
	}
	
	@RequestMapping(value="/addCustomer",method= RequestMethod.POST)
	public String addCustomer(@Valid Customer customer,
			BindingResult result,
			Model model){
		
		if(result.hasErrors()){
			model.addAttribute("result", result);
			return "customer";
		}else{
			customerStorageService.put(customer.getFirstName(), customer);
			return "showCustomer";
		}
		
	}
	
	@RequestMapping("/deleteCustomer")
	public ModelAndView deleteContact(String id){
		customerStorageService.delete(id);
		return new ModelAndView("redirect:customer");
	}

}
