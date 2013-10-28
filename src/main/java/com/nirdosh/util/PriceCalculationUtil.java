package com.nirdosh.util;

import com.nirdosh.data.model.Discount;
import com.nirdosh.data.model.Price;
import com.nirdosh.enums.CardType;

public class PriceCalculationUtil {
	
	public static double calculate(CardType type, Price price, Discount discount){
		
		double result = type.getNumber()*price.getValue()*(discount.getDiscount()/100);
		return result;
	}

}
