package com.dealdove.dealdove.service;

import com.dealdove.dealdove.dao.ProductRepository;
import com.dealdove.dealdove.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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

        productRepository.save(product);
        return product;
    }

    //    定義saveProduct方法，調用ProductRepository的save方法，用於保存產品。
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

//    public void addProductImageToProduct(Integer productId, ProductImageTable productImage) {
//        Product product = productRepository.findProductByproductID(productId);
//        if (product != null) {
//            product.addProductImage(productImage);
//            saveProduct(product);
//        }
//    }

//    public List<HashMap<String, String>> findProductByKeyword(String keyword){
//        List<Product> products = productRepository.findByProductNameOrProductDescription(keyword);
//        List<HashMap<String, String>> productNames = new ArrayList<>();
//        for (Product product : products) {
//            HashMap<String, String> productName = new HashMap<>();
//            productName.put("productName", product.getProductName());
//            productName.put("productID", product.getProductID().toString());
//            productName.put("productDescription", product.getProductDescription());
//            productNames.add(productName);
//        }
//        return productNames;
//    }

//    public List<ProductImageTable> getProductImagesByProductId(Integer productId) {
//        Product product = productRepository.findProductByproductID(productId);
//
//        return product != null ? product.getProductImageTables() : new ArrayList<>();
//    }

}
