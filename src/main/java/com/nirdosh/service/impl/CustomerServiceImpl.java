package com.nirdosh.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.nirdosh.dao.CustomerDAO;
import com.nirdosh.data.model.Customer;
import com.nirdosh.data.model.Payment;
import com.nirdosh.data.model.TrainningCourse;
import com.nirdosh.enums.CardType;
import com.nirdosh.enums.CourseType;
import com.nirdosh.enums.CustomerField;
import com.nirdosh.form.CustomerForm;
import com.nirdosh.service.CustomerService;

import static org.springframework.data.mongodb.core.query.Criteria.*;

@Service
public class CustomerServiceImpl implements CustomerService {

	private Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Inject
	CustomerDAO customerDAO;

	public void save(Customer customer) {
		customerDAO.put(customer);

	}

	public List<Customer> getAll() {
		return customerDAO.getAll();
	}

	public Customer getCustomerById(String id) {
		return customerDAO.get(id);
	}

	public void delete(String id) {
		customerDAO.delete(id);

	}

	public void updateBalance(String id, double amount) {

		Customer customer = customerDAO.get(id);
		customer.setBalance(customer.getBalance() + amount);
		
		// update payment history
		customer.getPaymentHistory().add(new Payment(new Date(), amount));
		
		customerDAO.put(customer);

	}

	public void updateCard(String id, CardType cardType) {
		if (cardType != null) {
			Customer customer = customerDAO.get(id);

			// change the cardType if its changed
			customer.getCustomerCard().setCardType(cardType);

			double balanceOnCard = customer.getCustomerCard().getBalance();
			balanceOnCard += cardType.getPrice();
			customer.getCustomerCard().setBalance(balanceOnCard);

			int entriesLeft = customer.getCustomerCard().getEntriesLeft();
			entriesLeft += cardType.getNumber();
			customer.getCustomerCard().setEntriesLeft(entriesLeft);
			
			// update payment history
			Payment payment = new Payment(new Date(),cardType.getPrice());
			customer.getPaymentHistory().add(payment);			

			customerDAO.put(customer);

		}

	}

	public void attendCourse(String customerId, TrainningCourse course) {
		LOGGER.debug("Course Price :{}",course.getPrice());
		
		Customer customer = getCustomerById(customerId);
		String courseId = course.getId();
		if (!customer.getCourseList().contains(courseId)) {
			customer.getCourseList().add(courseId);
			if (customer.getCustomerCard().isCardValid() && CourseType.WEEKLY.equals(course.getCourseType())) {
				customer.getCustomerCard().deductOne();
			} else {
				double balance = customer.getBalance() - course.getPrice();
				LOGGER.debug("Customer Balance Now:{}", balance);
				customer.setBalance(balance);
			}

			customerDAO.put(customer);
		}

	}

	public void updateCustomer(CustomerForm customerForm) {
		Query customerQuery = new Query(where("id").is(customerForm.getId()));
		
		Update customerUpdate = new Update();
		if(StringUtils.isNotEmpty(customerForm.getFirstName())){
			customerUpdate.set(CustomerField.FIRST_NAME.get(), customerForm.getFirstName());
		}
		
		if(StringUtils.isNotEmpty(customerForm.getLastName())){
			customerUpdate.set(CustomerField.LAST_NAME.get(), customerForm.getLastName());
		}
		
		if(StringUtils.isNotEmpty(customerForm.getEmail())){
			customerUpdate.set(CustomerField.EMAIL.get(), customerForm.getEmail());
		}
		
		if(StringUtils.isNotEmpty(customerForm.getHome())){
			LOGGER.debug("Home Telefone: {}",customerForm.getHome());
			customerUpdate.set(CustomerField.HOME.get(), customerForm.getHome());
		}
		
		if(StringUtils.isNotEmpty(customerForm.getMobile())){
			customerUpdate.set(CustomerField.MOBILE.get(), customerForm.getMobile());
		}
		
		customerUpdate.set(CustomerField.IS_SATSANGI.get(), customerForm.isSatsangi());
		
		customerDAO.update(customerQuery, customerUpdate);
	}

	public List<Customer> get(List<String> ids) {
		return customerDAO.get(ids);
	}

}
