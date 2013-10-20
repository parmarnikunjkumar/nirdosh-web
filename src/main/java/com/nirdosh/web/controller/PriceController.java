package com.nirdosh.web.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nirdosh.data.model.Price;

@Controller
public class PriceController {
	
	@Inject MongoTemplate mongoOperaions;
	
	@RequestMapping(value="/price")
	public String getPrices(HttpServletRequest request, Model model){
		Price price = new Price();
		model.addAttribute("price", price);
		model.addAttribute("priceList", mongoOperaions.findAll(Price.class));
		
		return "prices";
	}
	
	@RequestMapping(value="/addPrice", method=RequestMethod.POST)
	public String addPrice(Price price, Model model){
		mongoOperaions.save(price);
		return "price";
	}

}
