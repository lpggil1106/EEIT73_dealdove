package com.dealdove.dealdove.model.dao;

import com.dealdove.dealdove.model.enitity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    ProductCategory findByCategoryName(String categoryName);
}