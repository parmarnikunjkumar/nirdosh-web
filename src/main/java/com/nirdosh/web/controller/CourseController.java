package com.nirdosh.web.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nirdosh.data.model.Customer;
import com.nirdosh.data.model.TrainningCourse;
import com.nirdosh.enums.CourseType;
import com.nirdosh.service.CustomerService;
import com.nirdosh.service.TrainningCourseService;

@Controller
public class CourseController {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(CourseController.class);

	// @Inject
	// private TrainningCourseDAO courseDAO;

	@Inject
	private TrainningCourseService trainningCourseService;

	@Inject
	private CustomerService customerService;

//	@InitBinder
//	private void initBinder(WebDataBinder webDataBinder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
//		webDataBinder.registerCustomEditor(DateTime.class, new CustomDateEditor(
//				dateFormat, true));
//
//	}

	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public String welcome(HttpServletRequest request, Model model) {
		List<TrainningCourse> courses = trainningCourseService.getAll();
		model.addAttribute("coursesList", courses);
		model.addAttribute("course", new TrainningCourse());
		model.addAttribute("courseTypes", CourseType.values());
		return "sbm_courses";
	}

	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
	public String addCourse(TrainningCourse course, BindingResult result,
			Model model) {
		LOGGER.debug("Date:{}", course.getOnDate());
		trainningCourseService.addCourse(course);
		return "redirect:/course";
	}

	@RequestMapping(value = "/updateCourse", params="edit", method=RequestMethod.POST)
	public String editCourse(TrainningCourse course, Model model) {
	    course = trainningCourseService.getCourse(course.getId());
		model.addAttribute("course", course);
		model.addAttribute("customerList", customerService.getAll());
		return "sbm_edit_course";

	}

	@RequestMapping(value = "/updateCourse",params="update",method=RequestMethod.POST)
	public ModelAndView updateCourse(@ModelAttribute TrainningCourse course,
			Model model) {
		System.out.println(course.getName());
		trainningCourseService.save(course);
		return new ModelAndView("redirect:courses");
	}

	@RequestMapping(value = "/deleteCourse")
	public String deleteCourse(HttpServletRequest request, String id) {
		trainningCourseService.deleteCourse(id);
		return "redirect:/course";

	}

	@RequestMapping(value = "/updateCourse", params="repeat", method=RequestMethod.POST)
	public String repeatCourse(TrainningCourse course) {
		
		TrainningCourse repeatCourse = trainningCourseService.repeatCourse(course.getId());
		
		// update customers with this course and deduce their balance by course price as well
		for(String customerId: repeatCourse.getCustomersId()){
			customerService.attendCourse(customerId, repeatCourse);
		}
		
		return "redirect:/course";

	}

	@RequestMapping(value = "/updateCourse", params="addCustomer", method=RequestMethod.POST)
	public String addCustomers(TrainningCourse course, Model model) {
		
		course = trainningCourseService.getCourse(course.getId());
		List<Customer> customerList = customerService.getAll();
		model.addAttribute("course", course);
		model.addAttribute("customerList", customerList);

		return "sbm_add_customer_to_course";
	}

	@RequestMapping(value = "/doneAddCustomers", method = RequestMethod.POST)
	public ModelAndView doneAddCustomers(
			@ModelAttribute("course") TrainningCourse course, Model model) {
		LOGGER.debug("NAME:{}", course.getName());
		LOGGER.debug("ID:{}", course.getId());
		TrainningCourse courseToSave = trainningCourseService.getCourse(course
				.getId());
		courseToSave.setCustomersId(course.getCustomersId());
		trainningCourseService.save(courseToSave);

		// update all customers deduct thier balance with this course as well
		for (String customerId : course.getCustomersId()) {
				customerService.attendCourse(customerId, courseToSave);
			}
		return new ModelAndView("redirect:/course");
	}

	@RequestMapping(value = "/cancelCourse")
	public ModelAndView cancel(String courseId, Model model) {
		return new ModelAndView("redirect:/course");
	}

}
