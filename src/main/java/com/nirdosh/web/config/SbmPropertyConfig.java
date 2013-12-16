package com.nirdosh.web.config;

import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

import com.mongodb.Mongo;
import com.nirdosh.converter.DateTimeReadConverter;
import com.nirdosh.converter.DateTimeWriteConverter;

@Configuration
@PropertySource("classpath:app.properties")
public class SbmPropertyConfig extends AbstractMongoConfiguration {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Value("${mongodb.host}")
	private String mongoHost;

	@Value("${mongodb.db.name}")
	private String dbName;

//	@Bean
//	public MongoTemplate mongoOperations() throws UnknownHostException {
//		MongoTemplate mongoOperations =  new MongoTemplate(new Mongo(mongoHost), getDatabaseName());
//		
//		
//		return mongoOperations;
//	}

	@Override
	protected String getDatabaseName() {
		return dbName;
	}

	@Override
	public Mongo mongo() throws Exception {
		return new Mongo(mongoHost);
	}
	
	@Override
	protected String getMappingBasePackage() {
		return "com.nirdosh.converter";
	}
	
	
	
}
