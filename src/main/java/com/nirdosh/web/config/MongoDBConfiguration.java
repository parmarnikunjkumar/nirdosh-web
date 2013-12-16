package com.nirdosh.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.CustomConversions;

import com.mongodb.Mongo;
import com.nirdosh.converter.DateTimeReadConverter;
import com.nirdosh.converter.DateTimeWriteConverter;

@Configuration
public class MongoDBConfiguration  extends AbstractMongoConfiguration{

	@Override
	protected String getDatabaseName() {
		return "nirdoshdb";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new Mongo("localhost");
	}
	
	@Override
	public CustomConversions customConversions() {
		List<Converter<?, ?>> converterList = new ArrayList<Converter<?,?>>();
	    converterList.add(new DateTimeWriteConverter());
	    converterList.add(new DateTimeReadConverter());
	    
	    return new CustomConversions(converterList);
	}

}
