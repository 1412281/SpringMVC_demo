package com.lamtran.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lamtran.springmvc.dao.ProductDao;
import com.lamtran.springmvc.model.Product;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	

	public void saveProduct(Product product) {
		dao.saveProduct(product);
	}


	public Product getProductById(int id) {
		return dao.getById(id);
	}

	public List<Product> getAllProduct() {
		return dao.getAll();
		
	}

	public void updateProduct(Product product) {
		Product pro = dao.getById(product.getProID());
		if (pro != null) {
			pro.setProName(product.getProName());
			pro.setCatID(product.getCatID());
			pro.setPrice(product.getPrice());
			pro.setQuantity(product.getQuantity());
			pro.setTinyDes(product.getTinyDes());
		}
		
	}

	public void deleteProductById(int id) {
		dao.deleteProductById(id);
		
	}
	
}
