package com.lamtran.springmvc.service;

import java.util.List;

import com.lamtran.springmvc.model.Category;

/**
 *
 * @author LAMTRAN
 */
public interface CategoryService {

	Category getCategoryById(int id);

	List<Category> getAllCategory();

	void updateCategory(Category category);

	void saveCategory(Category category);

	void deleteCategoryById(int id);
}