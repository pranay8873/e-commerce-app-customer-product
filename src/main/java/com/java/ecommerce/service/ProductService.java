package com.java.ecommerce.service;

import com.java.ecommerce.model.Product;
import java.io.IOException;
import java.util.List;

public interface ProductService {
    // CREATE
    Product addProduct(Product product);
    
    // READ
    Product getProductById(int id);
    Product getProductByName(String name);
    List<Product> getAllProducts() throws IOException;
    
    // UPDATE
    Product updateProduct(Product product);
    
    // DELETE
    void deleteProduct(int id);
    
    // BUSINESS LOGIC
    List<Product> getProductsByCategory(String category) throws IOException;
}
