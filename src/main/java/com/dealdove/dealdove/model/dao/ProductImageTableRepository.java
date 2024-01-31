package com.dealdove.dealdove.model.dao;



import com.dealdove.dealdove.model.enitity.ProductImageTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageTableRepository extends JpaRepository<ProductImageTable, Long> {

}
