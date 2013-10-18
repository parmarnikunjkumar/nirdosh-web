package com.nirdosh.data.storage.service.mock.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nirdosh.data.storage.service.StorageService;
import com.nirdosh.web.profile.Dev;
import com.nirdosh.web.profile.Test;

@Service
@Dev
@Test
public class MockStorageService<T extends Serializable> implements StorageService<String, T>{

	private Map<String, T> cache = new HashMap<String,T>();


	public T get(String key) {
		return cache.get(key);
	}

	public void delete(String key) {
		cache.remove(key);
		
	}

	public void put(String key, T value) {
		cache.put(key, value);
		
	}

	public List<T> getAll() {
		return new ArrayList<T>(cache.values());
	}

	public void update(T value) {
		// TODO Auto-generated method stub
		
	}

}
