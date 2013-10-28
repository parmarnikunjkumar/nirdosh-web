package com.nirdosh.web.config;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

@Configurable
@PropertySource("classpath:app.properties")
public class PropertyConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Value("${mongodb.host}")
	private String mongoHost;

	@Value("${mongodb.db.name}")
	private String dbName;

	@Bean
	public MongoTemplate mongoOperations() throws UnknownHostException {
		return new MongoTemplate(new Mongo(mongoHost), dbName);
	}
}
