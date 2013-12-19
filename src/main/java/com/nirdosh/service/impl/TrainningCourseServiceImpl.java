package com.nirdosh.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.nirdosh.dao.TrainningCourseDAO;
import com.nirdosh.data.model.TrainningCourse;
import com.nirdosh.service.TrainningCourseService;

@Service
public class TrainningCourseServiceImpl implements TrainningCourseService {

	@Inject
	TrainningCourseDAO trainningCourseDAO;

	public TrainningCourse getCourse(String id) {
		return trainningCourseDAO.get(id);
	}

	public void deleteCourse(String id) {
		trainningCourseDAO.delete(id);

	}

	public List<TrainningCourse> getAll() {
		return trainningCourseDAO.getAll();
	}

	public void addCourse(TrainningCourse course) {
		trainningCourseDAO.addCourse(course);

	}

	public void save(TrainningCourse course) {
		trainningCourseDAO.save(course);

	}

	public List<TrainningCourse> getCourses(List<String> ids) {
		return trainningCourseDAO.getAll(ids);
	}

	public TrainningCourse repeatCourse(String courseId) {

		TrainningCourse trainingCourse = getCourse(courseId);
		DateTime currentOnDate = new DateTime(trainingCourse.getOnDate());

		TrainningCourse repeatCourse = new TrainningCourse();
		repeatCourse.setCustomers(trainingCourse.getCustomers());
		repeatCourse.setCustomersId(trainingCourse.getCustomersId());
		repeatCourse.setDuration(trainingCourse.getDuration());
		repeatCourse.setName(trainingCourse.getName());
		repeatCourse.setOnDate(currentOnDate.plusWeeks(1).toDate());
		repeatCourse.setPrice(trainingCourse.getPrice());
		repeatCourse.setCourseType(trainingCourse.getCourseType());
		
		trainningCourseDAO.addCourse(repeatCourse);
		
		return repeatCourse;
	}

	public List<TrainningCourse> getCourses(DateTime from) {
		// TODO Auto-generated method stub
		return null;
	}

}
