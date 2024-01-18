package com.serenity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serenity.exception.CategoryException;
import com.serenity.model.Category;
import com.serenity.model.Products;
import com.serenity.repository.CategoryRepository;
import com.serenity.repository.ProductRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) throws CategoryException {

		if (categoryRepository.existsById(category.getCategoryId())) {
			throw new CategoryException("Category already exists by id " + category.getCategoryId());
		}

		return categoryRepository.save(category);
	}

//	@Override
//	public List<Products> getAllProductsByCategoryId(int catid) throws CategoryException {
//		Optional<Category> categories = categoryRepository.findById(catid);
//
//		if (categories.isEmpty()) {
//			throw new CategoryException("Category doesn't exists with id " + catid);
//		}
//		
//		List<Products> list = categoryRepository.findAllProductsByCategoryId(catid);
//		
//		return list;
//	}

	@Override
	public Category updateCategoryById(int catId, Category category) throws CategoryException {

		Optional<Category> categories = categoryRepository.findById(catId);

		if (categories.isEmpty()) {
			throw new CategoryException("Category doesn't exists with id " + catId);
		}

		Category cat = categories.get();
		cat.setCategoryname(category.getCategoryname());
		cat.setCategorydescripiton(category.getCategorydescripiton());
		cat.setAddressCreatedDate(category.getAddressCreatedDate());
		cat.setAddressUpdatedDate(category.getAddressUpdatedDate());

		return categoryRepository.save(cat);
	}

	@Override
	public Category deleteCategoryById(int catId) throws CategoryException {

		Optional<Category> category = categoryRepository.findById(catId);

		if (category.isEmpty()) {
			throw new CategoryException("Category not found with id " + catId);
		}

		categoryRepository.delete(category.get());

		return category.get();
	}

	@Override
	public List<Category> getAllCategory() throws CategoryException {

		List<Category> list = categoryRepository.findAll();

		if (list.isEmpty()) {
			throw new CategoryException("No category found");
		}

		return list;
	}

}
