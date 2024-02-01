package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.dao.OrderRepository;
import com.dealdove.dealdove.model.dao.ProductCategoryRepository;
import com.dealdove.dealdove.model.dao.ProductRepository;
import com.dealdove.dealdove.model.enitity.Product;
import com.dealdove.dealdove.model.enitity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutService {


    private OrderRepository orderRepository;
//    宣告了一個私有屬性productRepository，代表對ProductRepository的依賴。



    @Autowired
    public CheckoutService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;

    }


}
