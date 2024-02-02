package com.dealdove.dealdove.model.dao;

import com.dealdove.dealdove.model.enitity.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, String> {
    List<ShoppingCartItem> findByUserID(String userID);


}
