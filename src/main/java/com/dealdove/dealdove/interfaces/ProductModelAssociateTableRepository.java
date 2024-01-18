package com.dealdove.dealdove.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductModelAssociateTableRepository extends JpaRepository<ProductModelAssociateTableRepository, Long> {

}