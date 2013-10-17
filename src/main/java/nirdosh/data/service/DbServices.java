package nirdosh.data.service;

import java.io.Serializable;
import java.util.List;

public interface DbServices<K extends Serializable, T extends Serializable> {

	boolean put(K key, T value);
	
	T get(K key);
	
	boolean delete(K key);
	
	List<T> getAll();
	
	void put(T value);
	
	void update(T value);
	
	void deleteByFirstName(String firstName);
	
}

