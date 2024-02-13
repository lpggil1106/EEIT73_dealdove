package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.dao.*;
import com.dealdove.dealdove.model.enitity.Coupon;
import com.dealdove.dealdove.model.enitity.CouponBase;
import com.dealdove.dealdove.model.enitity.Order;
import com.dealdove.dealdove.model.enitity.ShoppingCartItem;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
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
    private final ProductImageTableRepository productImageTableRepository;

    private final CouponRepository couponRepository;
    private final CouponBaseRepository couponBaseRepository;

    public List<Object[]> findCheckoutDetailByUserID(String userID) {
        return shoppingCartItemRepository.findCheckoutDetailByUserID(userID);
    }

    @Autowired
    public CheckoutService(CouponRepository couponRepository,CouponBaseRepository couponBaseRepository,
                           ProductRepository productRepository,
                           ProductModelAssociateTableRepository productModelAssociateTableRepository,
                           ModelInfoRepository modelInfoRepository,
                           ShoppingCartItemRepository shoppingCartItemRepository, ProductImageTableRepository productImageTableRepository, ProductImageTableRepository productImageTableRepository1,OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.productModelAssociateTableRepository = productModelAssociateTableRepository;
        this.modelInfoRepository = modelInfoRepository;
        this.shoppingCartItemRepository = shoppingCartItemRepository;
        this.productImageTableRepository = productImageTableRepository1;
        this.couponRepository = couponRepository;
        this.couponBaseRepository = couponBaseRepository;

    }

    public List<String> getProductImages(Integer productId) {
        return productImageTableRepository.findImagesByProductId(productId);
    }
    public String getProductName(int productID) {
        return productRepository.findProductNameById(productID);
    }
    public List<ShoppingCartItem> getCartItemsByToken(String token) {
        try {
            // 验证并解析 Token
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
            // 从 Token 中获取 userID
            String userID = decodedToken.getUid();
            // 使用 userID 获取购物车项
            return shoppingCartItemRepository.findByUserID(userID);
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }
    }

    public FirebaseToken getFirebaseToken(String userToken) {
        try {
            return FirebaseAuth.getInstance().verifyIdToken(userToken);
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUserIdFromToken(String token) throws FirebaseAuthException {
        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
        return decodedToken.getUid();
    }

    public Order saveOrderWithBuyerID(Order order, String token) {
        try {
            String buyerID = getUserIdFromToken(token);
            order.setBuyerID(buyerID); // 设置 buyerID
            return orderRepository.save(order); // 保存订单
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }


    public List<Coupon> getUserCoupons(String userID) {
        return couponRepository.findCouponsByOwnerID(userID);
    }

    public CouponBase getCouponBaseDetails(Integer couponBaseID) {
        return couponBaseRepository.findById(couponBaseID).orElse(null);
    }



//    public String getModelsForUser(String userID) {
//        ShoppingCartItem cartItem = shoppingCartItemRepository.findByUserID(userID);
//        return cartItem != null ? cartItem.getModels() : null; // 返回 models
//    }
//
//    public Integer getQuantityForUser(String userID) {
//        // 根据 userID 查找购物车项
//        ShoppingCartItem cartItem = shoppingCartItemRepository.findByUserID(userID);
//        // 如果找到了购物车项，返回商品数量；否则返回 null
//        return cartItem != null ? cartItem.getQuantity() : null;
//    }
}

