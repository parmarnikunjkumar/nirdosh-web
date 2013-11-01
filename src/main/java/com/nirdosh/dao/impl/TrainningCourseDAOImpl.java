package com.nirdosh.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.nirdosh.dao.TrainningCourseDAO;
import com.nirdosh.data.model.TrainningCourse;
@Service
public class TrainningCourseDAOImpl implements TrainningCourseDAO{
	
	@Inject MongoTemplate mongoOperations;

	public List<TrainningCourse> getAll() {
		return mongoOperations.findAll(TrainningCourse.class);
	}

	public void addCourse(TrainningCourse course) {
		mongoOperations.save(course);
		
	}

	public void delete(String id) {
		TrainningCourse course = mongoOperations.findById(id, TrainningCourse.class);
		mongoOperations.remove(course);
		
	}

	public TrainningCourse get(String id) {
		return mongoOperations.findById(id, TrainningCourse.class);
	}

	public void save(TrainningCourse course) {
		mongoOperations.save(course);
		
	}

}
