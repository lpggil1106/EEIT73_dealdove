package com.dealdove.dealdove.service;

import com.dealdove.dealdove.dao.OrderRepository;
import com.dealdove.dealdove.model.Order;
import com.dealdove.dealdove.model.OrderItem;
import com.dealdove.dealdove.model.Product;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public FirebaseToken getFirebaseToken(String userToken) {
        try {
            return FirebaseAuth.getInstance().verifyIdToken(userToken);
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }
    }


    public List<String> getOrderItemsNameByOrderID(LinkedHashMap<String, String> user) {
        FirebaseToken decodedToken = getFirebaseToken(user.get("idToken"));
        String buyerID = decodedToken.getUid();
        int status = (user.get("status")==null)?1:Integer.parseInt(user.get("status"));
        List<Order> orders = orderRepository.findOrderByBuyerIDAndStatus(buyerID,status);
        List<String> productList = new ArrayList<>();
        for(Order order : orders){
            List<OrderItem> orderItems = order.getOrderItems();
            for(OrderItem orderItem :orderItems){
                Product product = orderItem.getProduct();
                productList.add(product.getProductName());
            }
        }
        return productList;
    }
    public List<String> getOrderItemsQuantityByOrderID(LinkedHashMap<String, String> user) {
        FirebaseToken decodedToken = getFirebaseToken(user.get("idToken"));
        String buyerID = decodedToken.getUid();
        int status = (user.get("status")==null)?1:Integer.parseInt(user.get("status"));
        List<Order> orders = orderRepository.findOrderByBuyerIDAndStatus(buyerID,status);
        List<String> quantityList = new ArrayList<>();
        for(Order order : orders){
            List<OrderItem> orderItems = order.getOrderItems();
            for(OrderItem orderItem :orderItems){
                System.out.println(orderItem.getQuantity());
                quantityList.add(orderItem.getQuantity().toString());
            }
        }
        return quantityList;
    }



}


