package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.dao.ProductCategoryRepository;
import com.dealdove.dealdove.model.dao.ProductRepository;
import com.dealdove.dealdove.model.enitity.Product;
import com.dealdove.dealdove.model.enitity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    private ProductRepository productRepository;
//    宣告了一個私有屬性productRepository，代表對ProductRepository的依賴。

    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
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
    public Product saveProduct(String productName, String productDescription, String categoryName) {
    Integer productCategoryID = findCategoryIDByName(categoryName);
    if (productCategoryID == null) {
        // 處理錯誤情況，比如拋出一個異常或者返回 null
        throw new RuntimeException("Category not found for name: " + categoryName);
    }
        Product product = new Product();
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setProductCategoryID(productCategoryID);


        return productRepository.save(product);

    }

    public Integer findCategoryIDByName(String categoryName) {
        ProductCategory productCategory = productCategoryRepository.findByCategoryName(categoryName);
        if (productCategory != null) {
            return productCategory.getId(); // 使用 getId() 而不是 getCategoryID()
        } else {
            // 處理找不到對應類別名稱的情況，比如返回 null 或拋出異常
            return null;
        }
    }

}
