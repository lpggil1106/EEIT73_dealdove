package com.dealdove.dealdove.model.dao;

import com.dealdove.dealdove.model.enitity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findAllByOrderID(Integer orderID);


    List<OrderItem> findByOrderItemID(Integer oderItemID);
}