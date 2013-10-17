package nirdosh.web.config;

import java.net.UnknownHostException;
import java.util.Locale;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import nirdosh.data.model.Contact;
import nirdosh.data.mongo.service.MongoContactDbServices;
import nirdosh.data.service.DbServices;
import nirdosh.web.converter.CustomerConverter;
import nirdosh.web.interceptor.RequestCountInterceptor;

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

@EnableWebMvc
@Configuration
@ComponentScan(basePackages={"nirdosh.web.controller","nirdosh.web.google.controller"})
public class appConfig extends WebMvcConfigurerAdapter{
	
	private @Value("mongodb.host")
	String mongoDbHost;
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		
		registry.addConverter(new CustomerConverter());
//		registry.addConverter(new ParameterParamConverter());
	}
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		
//		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
//		TilesViewResolver viewResolver = new TilesViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
//		viewResolver.setViewClass(TilesView.class);
//		viewResolver;
		
		return viewResolver;
	}
	
//	@Bean
//	public TilesConfigurer tilesConfigurer(){
//		TilesConfigurer tilesConfigurer = new TilesConfigurer();
//		tilesConfigurer.setDefinitions(new String[]{"/WEB-INF/tiles.xml"});
//		return tilesConfigurer;
//	}
	
	@Bean
	public Validator validator(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		return factory.getValidator();
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
	
	@Bean
	DbServices<String, Contact> contactService(){
		return new MongoContactDbServices();
	}
}
