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
import com.enotes.exception.ResourceNotFoundException;
import com.enotes.service.CategoryService;
import com.enotes.util.CommonUtil;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/save-category")
	public ResponseEntity<?> saveCategory(@RequestBody CategoryDTO categoryDto) {
		Boolean saveCategory = categoryService.saveCategory(categoryDto);
		if (saveCategory) {
			return CommonUtil.createBuildResponseMessage("Category saved successfully", HttpStatus.CREATED);

		} else {
			return CommonUtil.createErrorResponseMessage("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/")
	public ResponseEntity<?> getAllCategory() {
		List<CategoryDTO> allCategory = categoryService.getAllCategory();
		if (CollectionUtils.isEmpty(allCategory)) {
			return ResponseEntity.noContent().build();
		} else {
			return CommonUtil.createBuildResponse(allCategory, HttpStatus.OK);
		}

	}

	@GetMapping("/active")
	public ResponseEntity<?> getActiveCategory() {
		List<CategoryResponse> allCategory = categoryService.getActiveCategory();
		if (CollectionUtils.isEmpty(allCategory)) {
			return ResponseEntity.noContent().build();
		} else {
			return CommonUtil.createBuildResponse(allCategory, HttpStatus.OK);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Integer id) {

		try {
			CategoryDTO categoryDtoById = categoryService.getCategoryById(id);
			if (ObjectUtils.isEmpty(categoryDtoById)) {
				// return new ResponseEntity<>("Category not found with id = " + id,
				// HttpStatus.NOT_FOUND);
				return CommonUtil.createErrorResponseMessage("Category not found with id = " + id,
						HttpStatus.NOT_FOUND);
			}
			return CommonUtil.createBuildResponse(categoryDtoById, HttpStatus.OK);
			// return new ResponseEntity<>(categoryDtoById, HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategoryById(@PathVariable Integer id) {
		Boolean deletedCategory = categoryService.deleteCategoryById(id);
		if (deletedCategory) {
			// return new ResponseEntity<>("Category Deleted Successfully", HttpStatus.OK);
			return CommonUtil.createBuildResponse("Category Deleted Successfully", HttpStatus.OK);
		}
		// return new ResponseEntity<>("Invalid Category ID = " + id,
		// HttpStatus.INTERNAL_SERVER_ERROR);
		return CommonUtil.createErrorResponseMessage("Invalid Category ID = " + id, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
