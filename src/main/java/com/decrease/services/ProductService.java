package com.decrease.services;

import com.decrease.entities.Product;
import com.decrease.repositories.ProductRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductService() {
    }

    public void insert(Product product) {
        repository.save(product);
    }

    public Product findById(Long id) {
        Optional<Product> productObj = repository.findById(id);
        Product productFinded = productObj.orElse(null);
        return productFinded;
    }

    public Product createInstance(String name, String description, Double price, String imgUrl) {
        Product product = new Product(null, name, description, price, imgUrl);
        repository.save(product);
        return product;
    }

    public Product getProductByName(String name) {
        Optional<Product> productObj = repository.findByName(name);
        Product productFinded = productObj.orElse(null);
        return productFinded;
    }
    
}