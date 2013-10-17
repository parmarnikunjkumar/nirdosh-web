package com.nirdosh.web.config;

import java.net.UnknownHostException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mongodb.Mongo;
import com.nirdosh.web.converter.CustomerConverter;
import com.nirdosh.web.interceptor.RequestCountInterceptor;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages={"com.nirdosh"})
public class appConfig extends WebMvcConfigurerAdapter{
	
	private @Value("mongodb.host")
	String mongoDbHost;
	
	@Override
	public void addFormatters(FormatterRegistry registry) {		
		registry.addConverter(new CustomerConverter());
	}
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();		
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");		
		return viewResolver;
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		
		registry.addInterceptor(localeChangeInterceptor);
		registry.addInterceptor(new RequestCountInterceptor());
	}
	
	@Bean
	public CookieLocaleResolver localeResolver(){
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setDefaultLocale(Locale.ENGLISH);
		return localeResolver;
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages/messages");
		messageSource.setDefaultEncoding("UTF-8");
		
		return messageSource;
	}
	
	
	/**
	 * Mongodb connection
	 */
	@Bean
	Mongo mongo() throws UnknownHostException{
		return new Mongo("localhost");
	}
	
	@Bean
	MongoTemplate mongoOperations(Mongo mongo){
		return new MongoTemplate(mongo, "customers");
	}
	
}
