package com.lamtran.springmvc.service;

import java.util.List;


import com.lamtran.springmvc.model.Product;
/**
 *
 * @author LAMTRAN
 */
public interface ProductService {
	
    Product getProductById(int id);
    
    List<Product> getAllProduct();
    
    void updateProduct(Product product);
    
    void saveProduct(Product product);
    
    void deleteProductById(int id);
}
