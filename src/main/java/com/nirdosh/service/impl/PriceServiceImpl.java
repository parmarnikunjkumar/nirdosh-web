package com.nirdosh.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.nirdosh.dao.PriceDAO;
import com.nirdosh.data.model.Price;
import com.nirdosh.enums.CardType;
import com.nirdosh.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService{

	@Inject PriceDAO priceDAO;
	
	public Price getPrice(String id) {
		return priceDAO.get(id);
	}

	public Price getPrice(CardType cardType) {
		return priceDAO.get(cardType);
	}

}
