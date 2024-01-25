package com.dealdove.dealdove.dao;

import com.dealdove.dealdove.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT * FROM order", nativeQuery = true)
    List<Order> findAllOrders();

}
