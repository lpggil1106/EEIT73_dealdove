package com.dealdove.dealdove.model.dao;

import com.dealdove.dealdove.model.enitity.ProductModelAssociateTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductModelAssociateTableRepository extends JpaRepository<ProductModelAssociateTable, Long> {

    List<ProductModelAssociateTable> findByProductID(Integer productID);

    @Query(value = "SELECT * FROM productModelAssociateTable",nativeQuery = true)
    List<ProductModelAssociateTable> getAllProduct();

    // 通过 modelName 和 productID 查找记录
    ProductModelAssociateTable findByModelNameAndProductID(String modelName, Integer productID);
    ProductModelAssociateTable save(ProductModelAssociateTable productModelAssociateTable);

    ProductModelAssociateTable findByModelName(String modelName);
}