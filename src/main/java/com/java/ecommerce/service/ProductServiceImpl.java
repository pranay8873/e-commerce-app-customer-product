package com.java.ecommerce.service;

import com.java.ecommerce.Exceptions.CustomerExistsExc;
import com.java.ecommerce.Exceptions.CustomerNotFoundExc;
import com.java.ecommerce.model.Product;
import com.java.ecommerce.repository.ProductRepository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) throws IOException {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) throws CustomerExistsExc {
        if (productRepository.exists(product.getId())) {
            throw new CustomerExistsExc("Product with ID " + product.getId() + " already exists!");
        }
        return productRepository.addProduct(product);
    }

    @Override
    public Product getProductById(int id) throws CustomerNotFoundExc {
        return productRepository.getProductById(id)
                .orElseThrow(() -> new CustomerNotFoundExc("Product with ID " + id + " not found"));
    }

    @Override
    public Product getProductByName(String name) throws CustomerNotFoundExc {
        return productRepository.getProductByName(name)
                .orElseThrow(() -> new CustomerNotFoundExc("Product with name '" + name + "' not found"));
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        return productRepository.getAllProducts();
    }

    @Override
    public Product updateProduct(Product product) throws CustomerNotFoundExc {
        Product existing = productRepository.getProductById(product.getId())
                .orElseThrow(() -> new CustomerNotFoundExc("Product not found"));
        return productRepository.updateProduct(product)
                .orElseThrow(() -> new CustomerNotFoundExc("Failed to update product"));
    }

    @Override
    public void deleteProduct(int id) throws CustomerNotFoundExc {
        boolean deleted = productRepository.deleteById(id);
        if (!deleted) {
            throw new CustomerNotFoundExc("Product with ID " + id + " not found");
        }
    }

    @Override
    public List<Product> getProductsByCategory(String category) throws IOException {
        return getAllProducts().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }
}
