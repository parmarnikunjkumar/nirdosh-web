package com.nirdosh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String welcome() {
		return "index_sbm";
	}
	
	@RequestMapping("home")
	public String home(){
		return "index_sbm";
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
