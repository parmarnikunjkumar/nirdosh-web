package com.nirdosh.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nirdosh.data.model.Address;
import com.nirdosh.data.model.Customer;
import com.nirdosh.data.model.CustomerCard;
import com.nirdosh.data.model.PaymentInfo;
import com.nirdosh.data.storage.service.StorageService;

@Controller
public class CustomerController {
	
	@Inject MongoTemplate mongoOperaions;
	
	@Autowired
	@Qualifier("customer")
	StorageService<String, Customer> customerStorageService;
	
	@Autowired
	@Qualifier("customerCard")
	StorageService<String, CustomerCard> customerCardStorageService;
	
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
			customerStorageService.put(UUID.randomUUID().toString(), customer);
			return "showCustomer";
		}
		
	}
	
	@RequestMapping("/deleteCustomer")
	public ModelAndView deleteCustomer(String id){
		customerStorageService.delete(id);
		return new ModelAndView("redirect:customer");
	}
	
	@RequestMapping("/editCustomer")
	public String editCustomer(String id, Model model){
		Customer customer = customerStorageService.get(id);
		model.addAttribute("customer", customer);
		return "editCustomer";
	}
	
	@RequestMapping("/updateCustomer")
	public ModelAndView updateCustomer(Customer customer,Model model){
		
		PaymentInfo paymentInfo = customer.getPaymentInfo();
		mongoOperaions.save(paymentInfo);
		
		customerStorageService.update(customer);
		
		return new ModelAndView("redirect:customer");
	}
	
	@RequestMapping("/incrementCount")
	public ModelAndView incrementCount(String id){
		System.out.println("ID:"+id);
		Customer customer = customerStorageService.get(id);
		customer.setEntriesLeft(customer.getEntriesLeft()+1);
		customerStorageService.update(customer);
		return new ModelAndView("redirect:customer");
	}
	
	@RequestMapping("/decrementCount")
	public ModelAndView decrementCount(String id){
		System.out.println("ID:"+id);
		Customer customer = customerStorageService.get(id);
		customer.setEntriesLeft(customer.getEntriesLeft()-1);
		customerStorageService.update(customer);
		return new ModelAndView("redirect:customer");
	}

}
