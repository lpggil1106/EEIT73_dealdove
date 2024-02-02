package com.dealdove.dealdove.model.dao;

import com.dealdove.dealdove.model.enitity.Order;
import com.dealdove.dealdove.model.enitity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT * FROM `order` WHERE buyerID= :buyerID", nativeQuery = true)
    List<Order> findAllOrders(@Param("buyerID") String buyerID);

    @Query(value = "SELECT * FROM `order` WHERE buyerID= :buyerID AND orderStatus= :orderStatus",nativeQuery = true)
    List<Order> findOrderByBuyerIDAndStatus(@Param("buyerID") String buyerID,@Param("orderStatus") int orderStatus);

    @Query(value = "SELECT * FROM  `order` WHERE buyerID= :buyerID AND orderStatus= :orderStatus LIMIT :start,:end",nativeQuery = true)
    List<Order> findOrderByBuyerIDAndStatus2(@Param("buyerID") String buyerID,@Param("orderStatus") int orderStatus,
                                            @Param("start")int start,@Param("end") int end);
    Order save(Order order);
}


