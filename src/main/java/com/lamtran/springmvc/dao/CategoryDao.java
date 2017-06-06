package com.lamtran.springmvc.dao;

import java.util.List;

import com.lamtran.springmvc.model.Category;
public interface CategoryDao {
	
	Category getById(int id);
	
	List<Category> getAll();
	
	void deleteCategoryById(int id);
	

	void saveCategory(Category Category);
}
