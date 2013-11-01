package com.nirdosh.web.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nirdosh.data.model.Customer;
import com.nirdosh.data.model.Price;
import com.nirdosh.enums.CardType;

@Controller
public class CustomerController {

	@Inject
	MongoTemplate mongoOperaions;

	// @Autowired
	// @Qualifier("customer")
	// StorageService<String, Customer> customerStorageService;
	//
	// @Autowired
	// @Qualifier("customerCard")
	// StorageService<String, CustomerCard> customerCardStorageService;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CustomerController.class);

	@RequestMapping(value = "/")
	public String index() {
		return "welcome";
	}
	
	@RequestMapping(value = "/index")
	public String welcome() {
		return "index";
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String getCustomer(HttpServletRequest request, Model model) {

		model.addAttribute("customer", new Customer());
		model.addAttribute("customerList",
				mongoOperaions.findAll(Customer.class));

		return "customer";
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String addCustomer(@Valid Customer customer, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			model.addAttribute("result", result);
			return "customer";
		} else {
			Query query = new Query(Criteria.where("cardType").is(
					customer.getCardType()));
			Price price = mongoOperaions.findOne(query, Price.class);
			setPrice(customer, price);
			
			customer.setEntriesLeft(customer.getCardType().getNumber());			
			mongoOperaions.save(customer);
			return "showCustomer";
		}

	}

	@RequestMapping("/deleteCustomer")
	public ModelAndView deleteCustomer(String id) {
		mongoOperaions.remove(mongoOperaions.findById(id, Customer.class));
		;
		return new ModelAndView("redirect:customer");
	}

	@RequestMapping("/editCustomer")
	public String editCustomer(String id, Model model) {
		Customer customer = mongoOperaions.findById(id, Customer.class);
		model.addAttribute("customer", customer);
		model.addAttribute("cardTypes", CardType.values());
		return "editCustomer";
	}

	@RequestMapping("/updateCustomer")
	public ModelAndView updateCustomer(Customer customer, Model model) {
		
		Query query = new Query(Criteria.where("cardType").is(
				customer.getCardType()));
		Price price = mongoOperaions.findOne(query, Price.class);
		setPrice(customer, price);
		mongoOperaions.save(customer);
		return new ModelAndView("redirect:customer");
	}

	@RequestMapping("/incrementCount")
	public ModelAndView incrementCount(String id) {
		Customer customer = mongoOperaions.findById(id, Customer.class);
		customer.setEntriesLeft(customer.getEntriesLeft() + 1);
		incrementCurrentBalance(customer);
		mongoOperaions.save(customer);
		return new ModelAndView("redirect:customer");
	}

	@RequestMapping("/decrementCount")
	public ModelAndView decrementCount(String id) {
		System.out.println("ID:" + id);
		Customer customer = mongoOperaions.findById(id, Customer.class);
		customer.setEntriesLeft(customer.getEntriesLeft() - 1);
		decrementCurrentBalance(customer);
		mongoOperaions.save(customer);
		return new ModelAndView("redirect:customer");
	}
	
	@RequestMapping("/cancel")
	public ModelAndView cancel() {
		return new ModelAndView("redirect:customer");
	}

	// ----- private methods ---//

	private void setPrice(Customer customer, Price price) {
		if (price != null && customer.getPaymentInfo()!=null) {
			double priceToPay = price.getValue()-customer.getPaymentInfo().getCurrentBalance();
			if(customer.getEntriesLeft()==0 && priceToPay==0 && customer.getPaymentInfo().getCurrentBalance()!=0){
				customer.setEntriesLeft(customer.getCardType().getNumber());
			}
			customer.getPaymentInfo().setAmountToPay(priceToPay);
		}
	}
	
	private void decrementCurrentBalance(Customer customer){
		Price price = getPrice(customer.getCardType());
		double currentBalance = customer.getPaymentInfo().getCurrentBalance();
		currentBalance = currentBalance - (price.getValue()/customer.getCardType().getNumber());
		customer.getPaymentInfo().setCurrentBalance(currentBalance);
		
	}
	
	private void incrementCurrentBalance(Customer customer){
		Price price = getPrice(customer.getCardType());
		double currentBalance = customer.getPaymentInfo().getCurrentBalance();
		currentBalance = currentBalance + (price.getValue()/customer.getCardType().getNumber());
		customer.getPaymentInfo().setCurrentBalance(currentBalance);
		
	}
	
	private Price getPrice(CardType cardType){
		Query query = new Query(Criteria.where("cardType").is(cardType));
		return mongoOperaions.findOne(query, Price.class);
	}

}