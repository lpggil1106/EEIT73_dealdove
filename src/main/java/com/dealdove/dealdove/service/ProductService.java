package com.dealdove.dealdove.service;

import com.dealdove.dealdove.interfaces.ProductRepository;
import com.dealdove.dealdove.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        product.setCreateTime(Instant.now());
        product.setLastEdit(Instant.now());

        return productRepository.save(product);
    }
}
