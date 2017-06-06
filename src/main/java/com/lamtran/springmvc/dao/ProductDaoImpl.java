package com.lamtran.springmvc.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.lamtran.springmvc.model.Product;

@Repository("productsDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao{

	
	public void deleteProductById(int id) {
		Query query = getSession().createSQLQuery("delete from product where proId = :id");
        query.setString("id", String.valueOf(id));
        query.executeUpdate();
	}


	public Product getById(int id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAll() {
		Criteria criteria = createEntityCriteria();
         List<Product> result = criteria.list();
         return result;
	}


	public void saveProduct(Product product) {
		persist(product);
	}



	
}
