package com.dealdove.dealdove.dao;

import com.dealdove.dealdove.model.Order;
import com.dealdove.dealdove.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    //    @Query(value = "SELECT * FROM order", nativeQuery = true)
//    List<Order> findAllOrders();
    @Query(value = "SELECT sellerID FROM `order`", nativeQuery = true)
    public String test();

    @Query(value ="SELECT * FROM `order` WHERE buyerID = :buyerID AND orderStatus = :orderStatus", nativeQuery = true)
    List<Order> findOrderByBuyerIDAndStatus(@Param("buyerID") String buyerID,@Param("orderStatus") int orderStatus);


}


