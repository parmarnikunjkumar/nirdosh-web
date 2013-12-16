package com.nirdosh.service;

import java.util.List;

import com.nirdosh.data.model.TrainningCourse;

public interface TrainningCourseService {
	
	TrainningCourse getCourse(String id);
	
	void deleteCourse(String id);
	
	List<TrainningCourse> getAll();
	
	void addCourse(TrainningCourse course);
	
	void save(TrainningCourse course);
	
	List<TrainningCourse> getCourses(List<String> ids);

}
