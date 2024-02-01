package com.dealdove.dealdove.model.dao;

import com.dealdove.dealdove.model.enitity.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, String> {
    ShoppingCartItem findByUserID(String userID);

    ShoppingCartItem findByProductID(Integer productID);
}
