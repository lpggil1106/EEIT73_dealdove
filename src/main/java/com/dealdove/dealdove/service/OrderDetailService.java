package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.dao.OrderRepository;
import com.dealdove.dealdove.model.dto.OrderDetailDTO;
import com.dealdove.dealdove.model.dto.ShoppingCartDTO;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class OrderDetailService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderDetailService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    public FirebaseToken getFirebaseToken(String userToken) {
        try {
            return FirebaseAuth.getInstance().verifyIdToken(userToken);
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }
    }
    public Map<String, List<OrderDetailDTO>> findOrderBySellerID(LinkedHashMap<String, String> user) {
        FirebaseToken decodedToken = getFirebaseToken(user.get("idToken"));
        String sellerID = decodedToken.getUid();
        sellerID = "IPj0OOwDSOawidT5dqyajY3M7622";
        System.out.println("sellerID: " + sellerID);
        List<Object[]> queryResults = orderRepository.findOrderBySellerID(sellerID);
        Map<String, List<OrderDetailDTO>> groupedByBuyer = new HashMap<>();

        for (Object[] resultArray : queryResults) {
            OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
            orderDetailDTO.setUserName((String) resultArray[0]);
            orderDetailDTO.setBuyerID((String) resultArray[1]);
            orderDetailDTO.setOrderID((Integer) resultArray[2]);
            orderDetailDTO.setProductName((String) resultArray[3]);
            orderDetailDTO.setQuantity((Integer) resultArray[4]);
            orderDetailDTO.setModel((String) resultArray[5]);
            orderDetailDTO.setTotalPrice((Integer) resultArray[6]);
            orderDetailDTO.setOrderStatus((Integer) resultArray[7]);
            orderDetailDTO.setShippingAddress((String) resultArray[8]);
            orderDetailDTO.setCoverImageURL((String) resultArray[9]);


            if(groupedByBuyer.containsKey(orderDetailDTO.getBuyerID())){
                groupedByBuyer.get(orderDetailDTO.getBuyerID()).add(orderDetailDTO);
            }else{
                List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
                orderDetailDTOList.add(orderDetailDTO);
                groupedByBuyer.put(orderDetailDTO.getBuyerID(), orderDetailDTOList);
            }
        }
        System.out.println("groupedByBuyer: " + groupedByBuyer);
        return groupedByBuyer;
    }
}
