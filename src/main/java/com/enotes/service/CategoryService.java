/*
 * Copyright (c) 2024 Shiva
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shiva.
 * You shall not disclose or use it except in accordance with the terms of the
 * license agreement you entered into with Shiva.
 */
package com.enotes.service;

import java.util.List;

import com.enotes.dto.CategoryDTO;
import com.enotes.dto.CategoryResponse;

public interface CategoryService {
	public Boolean saveCategory(CategoryDTO categoryDto);

	public List<CategoryDTO> getAllCategory();

	public List<CategoryResponse> getActiveCategory();

	public CategoryDTO getCategoryById(Integer id);

	public Boolean deleteCategoryById(Integer id);
}
