package com.nirdosh.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.nirdosh.data.model.TrainningCourse;


public interface TrainningCourseDAO {
	
	List<TrainningCourse> getAll();
	
	void addCourse(TrainningCourse course);
	
	void delete(String id);
	
	TrainningCourse get(String id);
	
	void save(TrainningCourse course);
	
	List<TrainningCourse> getAll(List<String> ids);
	
	void update(Query query, Update update);
	
	List<TrainningCourse> get(Query query);

}