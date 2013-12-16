package com.nirdosh.converter;

import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.core.convert.converter.Converter;

import com.mongodb.DBObject;

public class DateTimeReadConverter implements Converter<DBObject, DateTime>{

	public DateTime convert(DBObject source) {
		Date date = (Date)source.get("date");
		return new DateTime(date);
	}

}
