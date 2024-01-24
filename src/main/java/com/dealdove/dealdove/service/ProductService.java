package com.dealdove.dealdove.service;

import com.dealdove.dealdove.interfaces.ProductRepository;
import com.dealdove.dealdove.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findProduct() {
        return productRepository.findProduct();
    }
    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }
    public Product getProductByID(Integer productID){
        return productRepository.findProductByproductID(productID);
    }
    public void saveProduct(Integer userID, Integer productPrice, String productName, Integer productCategoryID, Integer productModelID, Integer productImageID, String productDescription, Integer stockQuantity, Byte isAvailable) {

        Product product = new Product();
        product.setUserID(userID);
        product.setProductName(productName);
        product.setProductCategoryID(productCategoryID);
        product.setProductModelID(productModelID);
        product.setProductDescription(productDescription);
        product.setIsAvailable(isAvailable);



        productRepository.save(product);
    }



}
