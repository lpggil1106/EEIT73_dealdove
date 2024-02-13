package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.dao.OrderItemRepository;
import com.dealdove.dealdove.model.enitity.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    OrderItemRepository orderItemRepository;
    public OrderItemService(OrderItemRepository orderItemRepository){
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> findOrderItemByOrderItemID(Integer orderItemID){
        return orderItemRepository.findByOrderItemID(orderItemID);
    }
}
