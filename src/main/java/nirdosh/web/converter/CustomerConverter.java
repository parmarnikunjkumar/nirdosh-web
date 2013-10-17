package nirdosh.web.converter;

import nirdosh.web.domain.models.Customer;
import nirdosh.web.util.CustomerUtil;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

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
