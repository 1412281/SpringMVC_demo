package com.lamtran.springmvc.dao;
import java.util.List;

import com.lamtran.springmvc.model.Product;
public interface ProductDao {
	
	Product getById(int id);
	
	List<Product> getAll();
	
	void deleteProductById(int id);
	

	void saveProduct(Product product);
}
