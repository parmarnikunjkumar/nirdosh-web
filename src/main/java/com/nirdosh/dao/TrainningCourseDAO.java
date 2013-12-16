package com.nirdosh.dao;

import java.util.List;

import com.nirdosh.data.model.TrainningCourse;


public interface TrainningCourseDAO {
	
	List<TrainningCourse> getAll();
	
	void addCourse(TrainningCourse course);
	
	void delete(String id);
	
	TrainningCourse get(String id);
	
	void save(TrainningCourse course);
	
	List<TrainningCourse> getAll(List<String> ids);

}