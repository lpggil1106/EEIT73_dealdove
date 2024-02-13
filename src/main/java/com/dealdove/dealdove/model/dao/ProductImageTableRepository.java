package com.dealdove.dealdove.model.dao;



import com.dealdove.dealdove.model.enitity.ProductImageTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageTableRepository extends JpaRepository<ProductImageTable, Long> {
    @Query("SELECT p.image FROM ProductImageTable p WHERE p.product.productID = :productID")
    List<String> findImagesByProductId(@Param("productID") Integer productID);
}
