package com.nirdosh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("home")
	public String home(){
		return "welcome";
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
