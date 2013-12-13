package com.nirdosh.web.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nirdosh.data.model.Customer;
import com.nirdosh.data.model.TrainningCourse;
import com.nirdosh.service.CustomerService;
import com.nirdosh.service.TrainningCourseService;

@Controller
public class CourseController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(CourseController.class);
	
//	@Inject
//	private TrainningCourseDAO courseDAO;
	
	@Inject private TrainningCourseService trainningCourseService;
	
	@Inject private CustomerService customerService;
	
	@InitBinder
	private void initBinder(WebDataBinder webDataBinder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat, true));
		
	}
	
	@RequestMapping(value="/course", method = RequestMethod.GET)
	public String welcome(HttpServletRequest request, Model model){
		List<TrainningCourse> courses = trainningCourseService.getAll();
		model.addAttribute("coursesList", courses);
		model.addAttribute("course", new TrainningCourse());
		return "sbm_courses";
	}
	
	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
	public String addCourse(TrainningCourse course,BindingResult result, Model model){
		LOGGER.debug("Date:{}",course.getOnDate());
		trainningCourseService.addCourse(course);
		return "redirect:/course";
	}
	
	@RequestMapping(value = "/editCourse")
	public String editCourse(HttpServletRequest request, String id, Model model){
		TrainningCourse course = trainningCourseService.getCourse(id);
		model.addAttribute("course", course);
		return "sbm_edit_course";
		
	}
	
	@RequestMapping(value = "/updateCourse")
	public ModelAndView updateCourse(@ModelAttribute TrainningCourse course, Model model){
		System.out.println(course.getName());
		trainningCourseService.save(course);
		return new ModelAndView("redirect:courses");
	}

	@RequestMapping(value = "/deleteCourse")
	public String deleteCourse(HttpServletRequest request, String id){
		trainningCourseService.deleteCourse(id);
		return "redirect:/course";
		
	}
	
	@RequestMapping(value = "/repeatCourse")
	public String repeatCourse(HttpServletRequest request, String id){
		TrainningCourse trainingCourse = trainningCourseService.getCourse(id);
		Date currentOnDate = trainingCourse.getOnDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentOnDate);
		calendar.add(Calendar.WEEK_OF_MONTH, 1);
		
		TrainningCourse repeatCourse = new TrainningCourse();
		repeatCourse.setCustomers(trainingCourse.getCustomers());
		repeatCourse.setCustomersId(trainingCourse.getCustomersId());
		repeatCourse.setDuration(trainingCourse.getDuration());
		repeatCourse.setName(trainingCourse.getName());
		repeatCourse.setOnDate(calendar.getTime());
		
		trainningCourseService.addCourse(repeatCourse);
		return "redirect:/course";
		
	}
	
	@RequestMapping(value = "/addCustomersInCourse")
	public String addCustomers(String courseId,Model model){
		TrainningCourse course = trainningCourseService.getCourse(courseId);
		List<Customer> customerList = customerService.getAll();
		model.addAttribute("course", course);
		model.addAttribute("customerList", customerList);
		
		return "sbm_add_customer_to_course";
	}
	
	@RequestMapping(value = "/done", method= RequestMethod.POST)
	public ModelAndView addCustomerToCourse(@ModelAttribute("course") TrainningCourse course,Model model){
		LOGGER.debug("NAME:{}",course.getName());
		LOGGER.debug("ID:{}",course.getId());
		TrainningCourse courseToSave= trainningCourseService.getCourse(course.getId());
		courseToSave.setCustomersId(course.getCustomersId());
		trainningCourseService.save(courseToSave);
		return new ModelAndView("redirect:/course");
	}
	
	@RequestMapping(value = "/cancelCourse")
	public ModelAndView cancel(String courseId,Model model){
		return new ModelAndView("redirect:/course");
	}
	
	
}
