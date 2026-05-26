package com.java.ecommerce.repository;

import com.java.ecommerce.model.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private List<Product> products;

    public ProductRepository() throws IOException {
        this.products = new ArrayList<>();
    }

    public ProductRepository(List<Product> products) throws IOException {
        this.products = products;
    }

    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    public List<Product> getAllProducts() throws IOException {
        return new ArrayList<>(products);
    }

    public Optional<Product> getProductById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst();
    }

    public Optional<Product> getProductByName(String name) {
        return products.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst();
    }

    public Optional<Product> updateProduct(Product updatedProduct) {
        Optional<Product> existing = getProductById(updatedProduct.getId());
        existing.ifPresent(product -> {
            product.setName(updatedProduct.getName());
            product.setCategory(updatedProduct.getCategory());
            product.setMaxRetailPrice(updatedProduct.getMaxRetailPrice());
            product.setManufacturedYear(updatedProduct.getManufacturedYear());
            product.setQuantity(updatedProduct.getQuantity());
        });
        return existing;
    }

    public boolean deleteById(int id) {
        return products.removeIf(product -> product.getId() == id);
    }

    public boolean exists(int id) {
        return products.stream().anyMatch(p -> p.getId() == id);
    }
}
