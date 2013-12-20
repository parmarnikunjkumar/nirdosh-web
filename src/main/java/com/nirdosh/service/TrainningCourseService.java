package com.nirdosh.service;

import java.util.List;

import org.joda.time.DateTime;

import com.nirdosh.data.model.TrainningCourse;
import com.nirdosh.web.forms.TrainningCourseForm;

public interface TrainningCourseService {
	
	TrainningCourse getCourse(String id);
	
	void deleteCourse(String id);
	
	List<TrainningCourse> getAll();
	
	void addCourse(TrainningCourse course);
	
	void save(TrainningCourse course);
	
	List<TrainningCourse> getCourses(List<String> ids);
	
	TrainningCourse repeatCourse(String id);
	
	List<TrainningCourse> getCourses(DateTime from);
	
	void updateCourse(TrainningCourseForm courseForm);

}
