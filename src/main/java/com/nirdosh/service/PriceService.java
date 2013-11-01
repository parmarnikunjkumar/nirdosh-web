package com.nirdosh.service;

import com.nirdosh.data.model.Price;
import com.nirdosh.enums.CardType;

public interface PriceService {

	Price getPrice(String id);
	
	Price getPrice(CardType cardType);
}
