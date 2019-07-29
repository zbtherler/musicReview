package com.music.review.domain;

import java.io.Serializable;

public class AdminUser implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
