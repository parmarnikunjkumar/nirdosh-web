package com.nirdosh.web.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nirdosh.data.model.Price;

@Controller
public class PriceController {
	
	@Inject MongoTemplate mongoOperaions;
	
	@RequestMapping(value="/price")
	public String getPrices(HttpServletRequest request, Model model){
		Price price = new Price();
		model.addAttribute("price", price);
		model.addAttribute("priceList", mongoOperaions.findAll(Price.class));		
		return "sbm_prices";
	}
	
	@RequestMapping(value="/addPrice", method=RequestMethod.POST)
	public ModelAndView addPrice(Price price, Model model){
		List<Price> prices = mongoOperaions.findAll(Price.class);
		for(Price existingPrice : prices){
			if(existingPrice.getCardType().equals(price.getCardType())){
				return new ModelAndView("redirect:price");
			}
		}
		mongoOperaions.save(price);
		return new ModelAndView("redirect:price");
	}
	
	@RequestMapping(value="/deletePrice")
	public ModelAndView deletePrice(Price price){
		mongoOperaions.remove(price);
		return new ModelAndView("redirect:price");
	}
	
	@RequestMapping(value="/editPrice")
	public String editPrice(String id, Model model){
		model.addAttribute("price", mongoOperaions.findById(id, Price.class));
		return "sbm_edit_price";
	}
	
	@RequestMapping(value="/updatePrice")
	public ModelAndView updatePrice(Price price, Model model){
		mongoOperaions.save(price);
		return new ModelAndView("redirect:price");
	}

}
