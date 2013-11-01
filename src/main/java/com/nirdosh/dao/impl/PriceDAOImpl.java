package com.nirdosh.dao.impl;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.nirdosh.dao.PriceDAO;
import com.nirdosh.data.model.Price;
import com.nirdosh.enums.CardType;

@Service
public class PriceDAOImpl implements PriceDAO {
	
	@Inject MongoOperations mongoOperations;
	
	public Price get(String id) {
		return mongoOperations.findById(id, Price.class);
	}

	public Price get(CardType cardType) {
		Query query = new Query(Criteria.where("cardType").is(cardType));
		return mongoOperations.findOne(query, Price.class);
		
	}

}
