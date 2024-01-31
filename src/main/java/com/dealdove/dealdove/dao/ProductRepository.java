package com.dealdove.dealdove.dao;



import com.dealdove.dealdove.model.Product;
import com.google.firebase.internal.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM product WHERE productID = 1 ", nativeQuery = true)
    List<Product> findProduct();

    @Query(value = "SELECT * FROM product",nativeQuery = true)
    List<Product> getAllProduct();

    @NonNull
    List<Product> findAll();

    List<Product> findByProductID(int productID);

    @Query(value = "SELECT * FROM product WHERE productID = :productId", nativeQuery = true)
    List<Product> findProductByProductId(@Param("productId") int productId);


    Product findProductByproductID(Integer productID);

//    List<Product> findByProductNameOrProductDescription(String keyword);

    Product save(Product product);

    @Query(value = "SELECT * FROM product WHERE productID = :productId" , nativeQuery = true)
    List<Product> getProductByID(@Param("productId") int productId);
}
