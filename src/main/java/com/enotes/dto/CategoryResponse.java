/*
 * Copyright (c) 2024 Shiva
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shiva.
 * You shall not disclose or use it except in accordance with the terms of the
 * license agreement you entered into with Shiva.
 */
package com.enotes.dto;

public class CategoryResponse {
	private Integer id;
	private String name;
	private String description;

	public CategoryResponse() {
		super();
	}

 	public CategoryResponse(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}


}
	