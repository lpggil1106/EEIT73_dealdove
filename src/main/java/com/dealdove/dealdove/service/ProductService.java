package com.dealdove.dealdove.service;

import com.dealdove.dealdove.dao.ProductRepository;
import com.dealdove.dealdove.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    private ProductRepository productRepository;
//    宣告了一個私有屬性productRepository，代表對ProductRepository的依賴。

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
//    Autowired標註的建構子，用於注入ProductRepository的實例，以便在類別中可以使用該實例進行資料存取。

    public List<Product> findProduct() {
        return productRepository.findProduct();
    }
//    定義findProduct方法，該方法調用ProductRepository的findProduct方法，用於檢索產品列表。

    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }
    public Product getProductByID(Integer productID){
        return productRepository.findProductByproductID(productID);
    }
//    定義getProductByID方法，調用ProductRepository的findProductByproductID方法，通過產品ID檢索特定產品。
    public Product saveProduct(String productName,String productDescription,Integer productCategoryID) {
        Product product = new Product();
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setProductCategoryID(productCategoryID);


        return productRepository.save(product);

    }

}
