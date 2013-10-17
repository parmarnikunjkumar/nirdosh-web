package com.nirdosh.data.storage.service;

import java.io.Serializable;

public interface StorageService <K extends Serializable,T extends Serializable>{
	
	void put(K key ,T value);
	
	T get(K key);
	
	void delete(K key);
}
