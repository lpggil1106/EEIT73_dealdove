package com.dealdove.dealdove.dao;



import com.dealdove.dealdove.model.ProductImageTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageTableRepository extends JpaRepository<ProductImageTable, Long> {

}
