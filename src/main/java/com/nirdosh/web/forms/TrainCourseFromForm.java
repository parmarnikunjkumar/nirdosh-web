package com.nirdosh.web.forms;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

public class TrainCourseFromForm {

	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm")
	private DateTime from;

	public DateTime getFrom() {
		return from;
	}

	public void setFrom(DateTime from) {
		this.from = from;
	}
	
}
