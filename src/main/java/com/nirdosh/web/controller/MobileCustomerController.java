package com.nirdosh.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("mobile")
public class MobileCustomerController {

	@RequestMapping
	public String welcome(HttpServletRequest request, Model model){
		return "mobile/welcome-mobile";
	}
	@RequestMapping(value="/hello", method= RequestMethod.GET)
	public String hello(HttpServletRequest request, Model model){
		return "hello";
	}
	
	@RequestMapping(value="customers", method= RequestMethod.GET)
	public String listAll(HttpServletRequest request, Model model){
		return "mobile/customers";
	}
}
