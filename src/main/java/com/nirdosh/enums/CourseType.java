package com.nirdosh.enums;

public enum CourseType {
	
	WEEKLY(1),
	PRIVATE(2),
	SPECIAL(3);
	
	private int type;
	
	private CourseType(int type){
		this.type = type;
	}
}
