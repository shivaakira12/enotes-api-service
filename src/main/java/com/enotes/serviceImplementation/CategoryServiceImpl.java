package com.enotes.serviceImplementation;

import java.util.Date;
import java.util.List;

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
		category.setCreatedOn(new Date());
		category.setIsDeleted(false);
		category.setCreatedBy(1);
		Category saveCategory = categoryRepository.save(category);
		if (ObjectUtils.isEmpty(saveCategory)) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		List<Category> allCategories = categoryRepository.findAll();
		
		List<CategoryDTO> categoryDTOList = allCategories.stream().map(cat->modelmapper.map(cat, CategoryDTO.class)).toList();
		
		return categoryDTOList;
	}

	@Override
	public List<CategoryResponse> getActiveCategory() {
		List<Category> activeCategories = categoryRepository.findByIsActiveTrue();
		List<CategoryResponse> activeCategoryList = activeCategories.stream().map(cat->modelmapper.map(cat, CategoryResponse.class)).toList();
		return activeCategoryList;
	}

}
