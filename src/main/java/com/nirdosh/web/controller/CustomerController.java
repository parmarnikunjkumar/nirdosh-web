package com.nirdosh.web.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.Log4jConfigListener;

import com.nirdosh.data.model.Customer;
import com.nirdosh.data.model.CustomerCard;
import com.nirdosh.data.model.Price;
import com.nirdosh.enums.CardType;
import com.nirdosh.service.CustomerService;
import com.nirdosh.service.PriceService;
import com.nirdosh.service.TrainningCourseService;

@Controller
public class CustomerController {
	
	@Inject CustomerService customerService;
	
	@Inject PriceService priceService;
	
	@Inject TrainningCourseService trainngCourseService;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CustomerController.class);
	
	@RequestMapping(value = "/test")
	public String test(HttpServletRequest request) {
		LOGGER.debug("Http Request :{}",request);
		return "welcome";
	}
	@RequestMapping(value = "/index")
	public String welcome() {
		return "index";
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String getCustomer(HttpServletRequest request, Model model) {

		model.addAttribute("customer", new Customer());
		model.addAttribute("cardTypes",CardType.values());
		model.addAttribute("customerList",customerService.getAll());

		return "sbm_customer";
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String addCustomer(@Valid Customer customer, BindingResult result,
			Model model) {
		LOGGER.debug("Has Error:{}",result.hasErrors());
		if (result.hasErrors()) {
			model.addAttribute("result", result);
			return "sbm_customer";
		} else {
//			Query query = new Query(Criteria.where("cardType").is(
//					customer.getCardType()));
//			Price price = priceService.getPrice(customer.getCardType());
//			setPrice(customer, price);
//			
//			customer.setEntriesLeft(customer.getCardType().getNumber());			
			customerService.save(customer);
			return "redirect:/customer";
		}

	}

	@RequestMapping(value="/updateCustomer",params="buyCard")
	public String buyCard(Customer customer){
		LOGGER.debug("Buy Card for Customer");
		LOGGER.debug("CustomerCard :{}",customer.getCustomerCard());
		customerService.updateCard(customer.getId(), customer.getCustomerCard().getCardType());		
		return "redirect:/customer";
	}
	
	@RequestMapping(value="/updateCustomer", method=RequestMethod.POST) 
	public String updateBalance(Customer customer,@RequestParam(required=true) Double creditBalance, HttpServletRequest request){
		LOGGER.debug("Customer:{}",customer);	
		LOGGER.debug("Credit Balance:{}",creditBalance);
		customerService.updateBalance(customer.getId(), creditBalance);		
		return "redirect:/customer";
	}
	@RequestMapping(value="/updateCustomer", params="delete")
	public ModelAndView deleteCustomer(Customer customer) {
		LOGGER.debug("User for deletion -ID:{}, name:{}",customer.getId(),customer.getFirstName());
		customerService.delete(customer.getId());
		return new ModelAndView("redirect:customer");
	}

	@RequestMapping(value="/updateCustomer", params="edit", method=RequestMethod.POST)
	public String editCustomer(Customer customer, Model model) {
		// get all other fields as well
		customer = customerService.getCustomerById(customer.getId());
		model.addAttribute("customer", customer);
		model.addAttribute("cardTypes", CardType.values());
		return "sbm_edit_customer";
	}

	@RequestMapping(value="/updateCustomer", params="details", method=RequestMethod.POST)
	public String customerDetails(Customer customer, Model model){
		// get other fields as well
		customer = customerService.getCustomerById(customer.getId());
		model.addAttribute("courseList",trainngCourseService.getCourses(customer.getCourseList()));
		model.addAttribute("customer",customer);
		
		return "sbm_customer_details";
	}
	
	@RequestMapping(value="/updateCustomer", params="updateCustomer", method=RequestMethod.POST)
	public ModelAndView updateCustomer(Customer customer, Model model) {
		
		customerService.save(customer);

		return new ModelAndView("redirect:customer");
	}
//
//	@RequestMapping("/incrementCount")
//	public ModelAndView incrementCount(String id) {
//		Customer customer = customerService.getCustomerById(id);
//				
//		customer.setEntriesLeft(customer.getEntriesLeft() + 1);
//		incrementCurrentBalance(customer);
//		customerService.save(customer);
//		
//		return new ModelAndView("redirect:customer");
//	}
//
//	@RequestMapping("/decrementCount")
//	public ModelAndView decrementCount(String id) {
//		System.out.println("ID:" + id);
//		Customer customer = customerService.getCustomerById(id);
//				
//		customer.setEntriesLeft(customer.getEntriesLeft() - 1);
//		decrementCurrentBalance(customer);
//		customerService.save(customer);
//		
//		return new ModelAndView("redirect:customer");
//	}
	
	@RequestMapping("/cancel")
	public ModelAndView cancel() {
		return new ModelAndView("redirect:customer");
	}

	// ----- private methods ---//

//	private void setPrice(Customer customer, Price price) {
//		if (price != null && customer.getPaymentInfo()!=null) {
//			double priceToPay = price.getValue()-customer.getPaymentInfo().getCurrentBalance();
//			if(customer.getEntriesLeft()==0 && priceToPay==0 && customer.getPaymentInfo().getCurrentBalance()!=0){
//				customer.setEntriesLeft(customer.getCardType().getNumber());
//			}
//			customer.getPaymentInfo().setAmountToPay(priceToPay);
//		}
//	}
//	
//	private void decrementCurrentBalance(Customer customer){
//		Price price = getPrice(customer.getCardType());
//		double currentBalance = customer.getPaymentInfo().getCurrentBalance();
//		currentBalance = currentBalance - (price.getValue()/customer.getCardType().getNumber());
//		customer.getPaymentInfo().setCurrentBalance(currentBalance);
//		
//	}
//	
//	private void incrementCurrentBalance(Customer customer){
//		Price price = getPrice(customer.getCardType());
//		double currentBalance = customer.getPaymentInfo().getCurrentBalance();
//		currentBalance = currentBalance + (price.getValue()/customer.getCardType().getNumber());
//		customer.getPaymentInfo().setCurrentBalance(currentBalance);
//		
//	}
	
	private Price getPrice(CardType cardType){
		
		return priceService.getPrice(cardType);
				
	}

}
