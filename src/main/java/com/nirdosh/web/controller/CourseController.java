package com.nirdosh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@RequestMapping()
	public String welcome(){
		return "courses";
	}

}
