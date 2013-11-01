package com.nirdosh.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nirdosh.dao.TrainningCourseDAO;
import com.nirdosh.data.model.TrainningCourse;

@Controller
public class CourseController {
	
	@Inject
	private TrainningCourseDAO courseDAO;
	
	@InitBinder
	private void initBinder(WebDataBinder webDataBinder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat, true));
		
	}
	
	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public String welcome(HttpServletRequest request, Model model){
		List<TrainningCourse> courses = courseDAO.getAll();
		model.addAttribute("coursesList", courses);
		model.addAttribute("course", new TrainningCourse());
		return "courses";
	}
	
	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
	public ModelAndView addCourse(TrainningCourse course,BindingResult result, Model model){
		System.out.println("we are here");
		System.out.println(course.getOnDate());
		courseDAO.addCourse(course);
		return new ModelAndView("redirect:courses");
	}
	
	@RequestMapping(value = "/editCourse")
	public String editCourse(String id, Model model){
		TrainningCourse course = courseDAO.get(id);
		model.addAttribute("course", course);
		return "editCourse";
		
	}
	
	@RequestMapping(value = "/updateCourse")
	public ModelAndView updateCourse(TrainningCourse course, Model model){
		courseDAO.save(course);
		return new ModelAndView("redirect:courses");
	}

	@RequestMapping(value = "/deleteCourse")
	public ModelAndView deleteCourse(String id){
		courseDAO.delete(id);
		return new ModelAndView("redirect:courses");
		
	}
	
	@RequestMapping(value = "/addCustomers")
	public String addCustomerToCourse(String courseId,Model model){
		return "";
	}
}
