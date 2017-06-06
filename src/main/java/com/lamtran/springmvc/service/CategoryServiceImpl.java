package com.lamtran.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lamtran.springmvc.dao.CategoryDao;
import com.lamtran.springmvc.model.Category;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao dao;
	

	public void saveCategory(Category Category) {
		dao.saveCategory(Category);
	}


	public Category getCategoryById(int id) {
		return dao.getById(id);
	}

	public List<Category> getAllCategory() {
		return dao.getAll();
		
	}

	public void updateCategory(Category Category) {
		Category pro = dao.getById(Category.getCatID());
		if (pro != null) {
			pro.setCatName(Category.getCatName());
			pro.setCatID(Category.getCatID());
		}
		
	}

	public void deleteCategoryById(int id) {
		dao.deleteCategoryById(id);
		
	}
	
}
