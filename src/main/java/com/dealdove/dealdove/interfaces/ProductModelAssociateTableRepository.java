package com.dealdove.dealdove.interfaces;

import com.dealdove.dealdove.model.ProductCategory;
import com.dealdove.dealdove.model.ProductModelAssociateTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductModelAssociateTableRepository extends JpaRepository<ProductModelAssociateTable, Long> {
    @Query(value = "SLELCT * FROM productmodelassociateTable" , nativeQuery = true)
    List<ProductCategory> findAllProductCategories();
}