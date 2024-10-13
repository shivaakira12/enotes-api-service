package com.enotes.service;

import java.util.List;

import com.enotes.dto.CategoryDTO;
import com.enotes.dto.CategoryResponse;

public interface CategoryService {
	public Boolean saveCategory(CategoryDTO categoryDto);

	public List<CategoryDTO> getAllCategory();

	public List<CategoryResponse> getActiveCategory();
}
