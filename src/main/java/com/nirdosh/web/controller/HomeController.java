package com.nirdosh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String welcome() {
		return "redirect:/customer";
	}
	
	@RequestMapping("home")
	public String home(){
		return "redirect:/customer";
	}
	@RequestMapping("about")
	public String about(){
		return "about";
	}
	
	@RequestMapping("contact")
	public String contact(){
		return "contact";
	}
	
	

}
