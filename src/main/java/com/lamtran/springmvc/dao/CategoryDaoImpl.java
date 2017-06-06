package com.lamtran.springmvc.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.lamtran.springmvc.model.Category;

@Repository("categorysDao")
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao{

	
	public void deleteCategoryById(int id) {
		Query query = getSession().createSQLQuery("delete from category where proId = :id");
        query.setString("id", String.valueOf(id));
        query.executeUpdate();
	}


	public Category getById(int id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	public List<Category> getAll() {
		Criteria criteria = createEntityCriteria();
        return (List<Category>) criteria.list();
		
	}


	public void saveCategory(Category category) {
		persist(category);
	}



	
}
