package com.enotes.util;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.enotes.dto.CategoryDTO;
import com.enotes.exception.ValidationException;

@Component
public class Validation {
	public void CategoryValidation(CategoryDTO categoryDto) {
		Map<String, Object> error = new LinkedHashMap<>();
		if (ObjectUtils.isEmpty(categoryDto)) {
			throw new IllegalArgumentException("Category Object/JSON should not be blank");
		} else {

			// Validation for Category getName
			if (ObjectUtils.isEmpty(categoryDto.getName())) {
				error.put("name", "name field is empty or null");
			}
			if (categoryDto.getName().length() < 10) {
				error.put("name", "name field is min 10");
			}
			if (categoryDto.getName().length() > 100) {
				error.put("name", "name field is max 10");
			}
			// Validation for Category description
			if (ObjectUtils.isEmpty(categoryDto.getDescription())) {
				error.put("description", "description field is empty or null");
			}

			// Validation for Category isActive
			if (ObjectUtils.isEmpty(categoryDto.getIsActive())) {
				error.put("isActive", "isActive field is empty or null");
			} else {
				if (categoryDto.getIsActive() != Boolean.TRUE.booleanValue()
						&& categoryDto.getIsActive() != Boolean.FALSE.booleanValue()) {
					error.put("isActive", "InValid for IsActive field");
				}
			}
		}
		if (!error.isEmpty()) {
			throw new ValidationException(error);
		}
	}
}
