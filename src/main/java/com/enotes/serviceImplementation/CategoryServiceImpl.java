/*
 * Copyright (c) 2024 Shiva
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shiva.
 * You shall not disclose or use it except in accordance with the terms of the
 * license agreement you entered into with Shiva.
 */
package com.enotes.serviceImplementation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.enotes.dto.CategoryDTO;
import com.enotes.dto.CategoryResponse;
import com.enotes.entity.Category;
import com.enotes.repository.CategoryRepository;
import com.enotes.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelmapper;

	@Override
	public Boolean saveCategory(CategoryDTO categoryDto) {
		Category category = modelmapper.map(categoryDto, Category.class);
		if(ObjectUtils.isEmpty(category.getId())) {
			category.setCreatedOn(new Date());
			category.setIsDeleted(false);
			category.setCreatedBy(1);
		}
		else {
			updateCategory(category);
		}
		Category saveCategory = categoryRepository.save(category);
		if (ObjectUtils.isEmpty(saveCategory)) {
			return false;
		} else {
			return true;
		}
	}

	private void updateCategory(Category category) {
		Optional<Category> findById = categoryRepository.findById(category.getId());
		if(findById.isPresent()) {
			Category existCategory = findById.get();
			category.setCreatedBy(existCategory.getCreatedBy());
			category.setCreatedOn(existCategory.getCreatedOn());
			category.setIsDeleted(existCategory.getIsDeleted());
			
			category.setUpdatedBy(1);
			category.setUpdatedOn(new Date());
		}
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		List<Category> allCategories = categoryRepository.findByIsDeletedFalse();

		List<CategoryDTO> categoryDTOList = allCategories.stream().map(cat -> modelmapper.map(cat, CategoryDTO.class))
				.toList();

		return categoryDTOList;
	}

	@Override
	public List<CategoryResponse> getActiveCategory() {
		List<Category> activeCategories = categoryRepository.findByIsActiveTrueAndIsDeletedFalse();
		List<CategoryResponse> activeCategoryList = activeCategories.stream()
				.map(cat -> modelmapper.map(cat, CategoryResponse.class)).toList();
		return activeCategoryList;
	}

	@Override
	public CategoryDTO getCategoryById(Integer id) {
		Optional<Category> findByIdCategory = categoryRepository.findByIdAndIsDeletedFalse(id);
		if (findByIdCategory.isPresent()) {
			Category category = findByIdCategory.get();
			return modelmapper.map(category, CategoryDTO.class);
		}
		return null;
	}

	@Override
	public Boolean deleteCategoryById(Integer id) {
		Optional<Category> findByIdCategory = categoryRepository.findById(id);
		if (findByIdCategory.isPresent()) {
			Category category = findByIdCategory.get();
			category.setIsDeleted(true);
			categoryRepository.save(category);
			return true;
		}
		return false;

	}

}
