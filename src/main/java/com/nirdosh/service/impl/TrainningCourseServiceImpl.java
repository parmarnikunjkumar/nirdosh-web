package com.nirdosh.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.nirdosh.dao.TrainningCourseDAO;
import com.nirdosh.data.model.TrainningCourse;
import com.nirdosh.enums.TrainningCourseField;
import com.nirdosh.service.TrainningCourseService;
import com.nirdosh.web.forms.TrainningCourseForm;

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
		
		Query courseQuery = new Query(Criteria.where(TrainningCourseField.ONDATE.getName()).gte(from));
		return trainningCourseDAO.get(courseQuery);
	}

	public void updateCourse(TrainningCourseForm courseForm) {
		Query courseQuery = new Query(Criteria.where("id").is(courseForm.getId()));
		
		Update courseUpdate = new Update();
		
		if(StringUtils.isNotEmpty(courseForm.getName())){
			courseUpdate.set(TrainningCourseField.NAME.getName(), courseForm.getName());
		}
		
		if(courseForm.getDuration()!= -1){
			courseUpdate.set(TrainningCourseField.DURATION.getName(), courseForm.getDuration());
		}
		
		if(courseForm.getCouseType()!=null){
			courseUpdate.set(TrainningCourseField.COURSETYPE.getName(), courseForm.getCouseType());
		}
		
		if(courseForm.getOnDate()!=null){
			courseUpdate.set(TrainningCourseField.NAME.getName(), courseForm.getName());
		}
		
		if(courseForm.getPrice()!= -1){
			courseUpdate.set(TrainningCourseField.PRICE.getName(),courseForm.getPrice());
		}
		
		trainningCourseDAO.update(courseQuery,courseUpdate);
		
	}

}
