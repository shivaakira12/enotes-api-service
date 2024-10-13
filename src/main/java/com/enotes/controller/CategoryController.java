/*
 * Copyright (c) 2024 Shiva
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of Shiva.
 * You shall not disclose or use it except in accordance with the terms of the
 * license agreement you entered into with Shiva.
 */

package com.enotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enotes.dto.CategoryDTO;
import com.enotes.dto.CategoryResponse;
import com.enotes.entity.Category;
import com.enotes.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/save-category")
	public ResponseEntity<?> saveCategory(@RequestBody CategoryDTO categoryDto) {
		Boolean saveCategory = categoryService.saveCategory(categoryDto);
		if (saveCategory) {
			return new ResponseEntity<>("Category Saved Successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/")
	public ResponseEntity<?> getAllCategory() {
		List<CategoryDTO> allCategory = categoryService.getAllCategory();
		if (CollectionUtils.isEmpty(allCategory)) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(allCategory, HttpStatus.OK);
		}

	}

	@GetMapping("/active")
	public ResponseEntity<?> getActiveCategory() {
		List<CategoryResponse> allCategory = categoryService.getActiveCategory();
		if (CollectionUtils.isEmpty(allCategory)) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(allCategory, HttpStatus.OK);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Integer id) {
		CategoryDTO categoryDtoById = categoryService.getCategoryById(id);
		if(ObjectUtils.isEmpty(categoryDtoById)) {
			return new ResponseEntity<>("Category not found with id = "+id,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(categoryDtoById,HttpStatus.OK);
	}

	@DeleteMapping("/{id}")	
	public ResponseEntity<?> deleteCategoryById(@PathVariable Integer id) {
		Boolean deletedCategory = categoryService.deleteCategoryById(id);
		if(deletedCategory) {
			return new ResponseEntity<>("Category Deleted Successfully",HttpStatus.OK);
		}
		return new ResponseEntity<>("Invalid Category ID = " +id,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
