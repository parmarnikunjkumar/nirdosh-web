package com.nirdosh.web.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import com.nirdosh.web.domain.models.Customer;
import com.nirdosh.web.util.CustomerUtil;

public class CustomerConverter implements Converter<String,Customer> {

	public Customer convert(String source) {
		if(StringUtils.isEmpty(source)){
			return null;
		}
		Customer customer = new Customer();
		customer.setAge(CustomerUtil.parseAge(source));
		customer.setName(CustomerUtil.parseName(source));
		return customer;
	}

}
