package com.nirdosh.converter;

import org.joda.time.DateTime;
import org.springframework.core.convert.converter.Converter;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class DateTimeWriteConverter implements Converter<DateTime,DBObject>{

	public DBObject convert(DateTime source) {
		DBObject dbo = new BasicDBObject();
		dbo.put("_id", "joda_datetime");
		dbo.put("_class", source.getClass());
		dbo.put("date", source.toDate());
		return dbo;
	}


}
