package com.dealdove.dealdove.dao;



import com.dealdove.dealdove.model.Product;
import com.google.firebase.internal.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM product WHERE productId = 1 ", nativeQuery = true)
    List<Product> findProduct();

    @Query(value = "SELECT * FROM product",nativeQuery = true)
    List<Product> getAllProduct();

    @NonNull
    List<Product> findAll();

    Product findProductByproductID(Integer productId);

    Product save(Product product);



}
