package nirdosh.web.google.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;

import nirdosh.web.google.model.Customer;
import nirdosh.web.google.model.EMF;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.SortDirection;

@Controller
public class GoogleCustomerController {
	
	@Inject
	DatastoreService googleDatastore;
	
	@Inject
	Query customerTypeQuery;
	
//	@Inject 
//	EntityManagerFactory EMF;
	
	@RequestMapping(value="/addCustomerPage", method= RequestMethod.GET)
	public String getAddCustomerPage(ModelMap model){
		
		return "add";
	}
	
	@RequestMapping(value="/add", method= RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request, ModelMap model){
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		Customer customer = new Customer();
		customer.setFirstName(name);
		customer.setEmail(email);
		
//		Key customerKey = KeyFactory.createKey("Customer", name);
//		Date date = new Date();
//		
//		Entity customer = new Entity("Customer", customerKey);
//		customer.setProperty("name", name);
//		customer.setProperty("email", email);
//		customer.setProperty("date",date);
//		
//		DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
//		dataStore.put(customer);
		EntityManagerFactory emf = EMF.get();
		EntityManager em = emf.createEntityManager();
		try{			
			em.persist(customer);
		}catch(Exception e){
			
		}finally{
			em.close();
		}
		
		return new ModelAndView("redirect:list");
	}
	
	@RequestMapping(value="/list", method= RequestMethod.GET)
	public String listCustomer(ModelMap model){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("Customer").addSort("date",SortDirection.DESCENDING);
		List<Entity> customers = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(10));
		model.addAttribute("customerList",customers);
		
		return "list";
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/update/{name}", method= RequestMethod.GET)
	public String getUpdateCustomerPage(@PathVariable String name, HttpServletRequest request, ModelMap model){
		Query query = new Query("Customer");
		
		query.addFilter("name", FilterOperator.EQUAL, name);
		PreparedQuery pq = googleDatastore.prepare(query);
		Entity e = pq.asSingleEntity();
		
		model.addAttribute("customer",e);
		
		return "update";
	}
	
	@RequestMapping(value="/update", method= RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request, ModelMap model){
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String originalName= request.getParameter("originalName");
		
		Query query = new Query("Customer");
		query.addFilter("name", FilterOperator.EQUAL, originalName);
		PreparedQuery pq = googleDatastore.prepare(query);
		Entity customer = pq.asSingleEntity();
		
		customer.setProperty("name", name);
		customer.setProperty("email", email);
		customer.setProperty("date", new Date());
		
		googleDatastore.put(customer);
		
		return new ModelAndView("redirect:list");
	}
	
	@RequestMapping(value="/delete/{name}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable String name, HttpServletRequest request, ModelMap model){
		
		Query query = new Query("Customer");
		query.addFilter("name", FilterOperator.EQUAL, name);
		PreparedQuery pq = googleDatastore.prepare(query);
		Entity customer = pq.asSingleEntity();
		
		googleDatastore.delete(customer.getKey());
		
		
		return new ModelAndView("redirect:../list");
	}

}
