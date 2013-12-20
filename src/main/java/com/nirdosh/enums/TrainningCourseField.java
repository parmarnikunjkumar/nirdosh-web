package com.nirdosh.enums;

public enum TrainningCourseField {
	NAME("name"),
	ONDATE("onDate"),
	DURATION("duration"),
	COURSETYPE("courseType"),
	PRICE("price");
	
	private String name;
	
	private TrainningCourseField(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}
