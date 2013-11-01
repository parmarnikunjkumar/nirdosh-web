package com.nirdosh.dao;

import com.nirdosh.data.model.Price;
import com.nirdosh.enums.CardType;

public interface PriceDAO {
	
	Price get(String id);
	
	Price get(CardType cardType);

}
