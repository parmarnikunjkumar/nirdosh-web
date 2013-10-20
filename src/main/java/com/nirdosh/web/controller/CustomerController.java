package com.nirdosh.web.controller;

import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nirdosh.data.model.Customer;
import com.nirdosh.data.model.PaymentInfo;
import com.nirdosh.enums.CardType;

@Controller
public class CustomerController {
	
	@Inject MongoTemplate mongoOperaions;
	
//	@Autowired
//	@Qualifier("customer")
//	StorageService<String, Customer> customerStorageService;
//	
//	@Autowired
//	@Qualifier("customerCard")
//	StorageService<String, CustomerCard> customerCardStorageService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@RequestMapping(value="/")
	public String welcome(){
		return "welcome";
	}
	
	
	
	@RequestMapping(value="/customer",method= RequestMethod.GET)
	public String getCustomer(HttpServletRequest request, Model model){
		
		model.addAttribute("customer", new Customer());
		model.addAttribute("customerList", mongoOperaions.findAll(Customer.class));
		
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
			mongoOperaions.save(customer);
			return "showCustomer";
		}
		
	}
	
	@RequestMapping("/deleteCustomer")
	public ModelAndView deleteCustomer(String id){
		mongoOperaions.remove(mongoOperaions.findById(id, Customer.class));;
		return new ModelAndView("redirect:customer");
	}
	
	@RequestMapping("/editCustomer")
	public String editCustomer(String id, Model model){
		Customer customer = mongoOperaions.findById(id, Customer.class);
		model.addAttribute("customer", customer);
		model.addAttribute("cardTypes", CardType.values());
		return "editCustomer";
	}
	
	@RequestMapping("/updateCustomer")
	public ModelAndView updateCustomer(Customer customer,Model model){
		
		mongoOperaions.save(customer);				
		return new ModelAndView("redirect:customer");
	}
	
	@RequestMapping("/incrementCount")
	public ModelAndView incrementCount(String id){
		Customer customer = mongoOperaions.findById(id,Customer.class);
		customer.setEntriesLeft(customer.getEntriesLeft()+1);
		mongoOperaions.save(customer);
		return new ModelAndView("redirect:customer");
	}
	
	@RequestMapping("/decrementCount")
	public ModelAndView decrementCount(String id){
		System.out.println("ID:"+id);
		Customer customer = mongoOperaions.findById(id, Customer.class);
		customer.setEntriesLeft(customer.getEntriesLeft()-1);
		mongoOperaions.save(customer);
		return new ModelAndView("redirect:customer");
	}

}
