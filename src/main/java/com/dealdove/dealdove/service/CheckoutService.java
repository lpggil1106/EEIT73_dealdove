package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.dao.*;
import com.dealdove.dealdove.model.enitity.ModelInfo;
import com.dealdove.dealdove.model.enitity.Product;
import com.dealdove.dealdove.model.enitity.ProductCategory;
import com.dealdove.dealdove.model.enitity.ShoppingCartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutService {


    private final ShoppingCartItemRepository shoppingCartItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ProductModelAssociateTableRepository productModelAssociateTableRepository;
    private final ModelInfoRepository modelInfoRepository;

    @Autowired
    public CheckoutService(OrderRepository orderRepository,
                           ProductRepository productRepository,
                           ProductModelAssociateTableRepository productModelAssociateTableRepository,
                           ModelInfoRepository modelInfoRepository,
                           ShoppingCartItemRepository shoppingCartItemRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.productModelAssociateTableRepository = productModelAssociateTableRepository;
        this.modelInfoRepository = modelInfoRepository;
        this.shoppingCartItemRepository = shoppingCartItemRepository;
    }

    // ... 现有的方法 ...

    public String getModelsForUser(String userID) {
        ShoppingCartItem cartItem = shoppingCartItemRepository.findByUserID(userID);
        return cartItem != null ? cartItem.getModels() : null; // 返回 models
    }

    public Integer getQuantityForUser(String userID) {
        // 根据 userID 查找购物车项
        ShoppingCartItem cartItem = shoppingCartItemRepository.findByUserID(userID);
        // 如果找到了购物车项，返回商品数量；否则返回 null
        return cartItem != null ? cartItem.getQuantity() : null;
    }

    public Integer getProductNameForUser(String userID) {
        // 根据 userID 查找购物车项
        ShoppingCartItem cartItem = shoppingCartItemRepository.findByUserID(userID);
        // 如果找到了购物车项，返回商品数量；否则返回 null
        return cartItem != null ? cartItem.getQuantity() : null;
    }
}

