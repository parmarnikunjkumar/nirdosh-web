package com.nirdosh.data.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CustomerCard implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	private int type;
	
	private int entriesLeft;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getEntriesLeft() {
		return entriesLeft;
	}

	public void setEntriesLeft(int entriesLeft) {
		this.entriesLeft = entriesLeft;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}	
	
	
	
}
