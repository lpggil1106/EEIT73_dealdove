package com.dealdove.dealdove.interfaces;

import com.dealdove.dealdove.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageTableRepository extends JpaRepository<Order, Long> {


}
