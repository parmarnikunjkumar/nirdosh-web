package com.nirdosh.web.forms;

import java.util.Date;

import com.nirdosh.enums.CourseType;

public class TrainningCourseForm {
	
	private String id;
	
	private String name;
	
	private Date onDate;
	
	private double duration;
	
	private CourseType couseType;
	
	private double price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOnDate() {
		return onDate;
	}

	public void setOnDate(Date onDate) {
		this.onDate = onDate;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public CourseType getCouseType() {
		return couseType;
	}

	public void setCouseType(CourseType couseType) {
		this.couseType = couseType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
}
