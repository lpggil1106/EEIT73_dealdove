package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.dao.OrderRepository;
import com.dealdove.dealdove.model.enitity.Order;
import com.dealdove.dealdove.model.enitity.OrderItem;
import com.dealdove.dealdove.model.enitity.Product;
import com.dealdove.dealdove.model.enitity.ProductImageTable;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import ecpay.logistics.integration.domain.CreateCVSObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAllOrders(){
        return orderRepository.findAllOrders();
    }

    public FirebaseToken getFirebaseToken(String userToken) {
        try {
            return FirebaseAuth.getInstance().verifyIdToken(userToken);
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }
    }


    public List<HashMap<String,String>> getOrderItemsNameByOrderID(LinkedHashMap<String, String> user) {
        FirebaseToken decodedToken = getFirebaseToken(user.get("idToken"));
        String buyerID = decodedToken.getUid();
        int status = (user.get("status")==null)?1:Integer.parseInt(user.get("status"));
        List<Order> orders = orderRepository.findOrderByBuyerIDAndStatus(buyerID,status);
        List<HashMap<String,String>> productList = new ArrayList<>();
        for(Order order : orders){
            List<OrderItem> orderItems = order.getOrderItems();
            for(OrderItem orderItem :orderItems){
                HashMap<String,String> productMap = new HashMap<>();
                Product product = orderItem.getProduct();
                List<ProductImageTable> productImages =  product.getProductImageTables();
                for(ProductImageTable productImage : productImages){
                productMap.put("productName",product.getProductName());
                productMap.put("orderQuantity",orderItem.getQuantity().toString());
                productMap.put("productImage",productImage.getImage());
                productList.add(productMap);
                }
            }
        }
        System.out.println(productList);
        return productList;
    }

//    public void findOrderByBuyerIDAndStaus2(LinkedHashMap<String, String> user){
//        FirebaseToken decodedToken = getFirebaseToken(user.get("idToken"));
//        String buyerID = decodedToken.getUid();
//        int status = (user.get("status")==null)?1:Integer.parseInt(user.get("status"));
//        int page = 0;
//        List<Order> orders = orderRepository.findOrderByBuyerIDAndStatus2(buyerID,status,0,1);
//        List<HashMap<String,String>> productList = new ArrayList<>();
//        for(Order order : orders){
//            List<OrderItem> orderItems = order.getOrderItems();
//            for(int i = 0;i<2;i++){
//                OrderItem orderItem = orderItems.get(i);
//                HashMap<String,String> productMap = new HashMap<>();
//                Product product = orderItem.getProduct();
//                productMap.put("productName",product.getProductName());
//                productMap.put("orderQuantity",orderItem.getQuantity().toString());
//
//                productList.add(productMap);
//            }
//        }
//        System.out.println(productList.size()+"From 2");
//
//
//    }

    public String ecpayCheckout() {
        String uuId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
        AllInOne all = new AllInOne("");

        AioCheckOutALL obj = new AioCheckOutALL();
        obj.setMerchantTradeNo(uuId);
        obj.setMerchantTradeDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
        obj.setTotalAmount("500");
        obj.setTradeDesc("test Description");
        obj.setItemName("TestItem");
        // 交易結果回傳網址，只接受 https 開頭的網站，可以使用 ngrok
        obj.setReturnURL(" https://7ff5-118-163-218-100.ngrok-free.app/ecpayReturn");
        obj.setNeedExtraPaidInfo("N");
        // 商店轉跳網址 (Optional)
        obj.setClientBackURL("http://192.168.1.37:8080/");
        String form = all.aioCheckOut(obj, null);

        return form;
    }

    public String ecpayMap(String name, String phone){
        ecpay.logistics.integration.AllInOne all = new ecpay.logistics.integration.AllInOne("");
        CreateCVSObj obj = new CreateCVSObj();
        String uuId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
        obj.setMerchantID(uuId);
        obj.setMerchantID("2000132");
        obj.setMerchantTradeDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
        obj.setSenderName(name);
        obj.setSenderCellPhone(phone);
        obj.setIsCollection("N");
        obj.setServerReplyURL("幹你娘");
        String result = all.create(obj);
        return result;
    }

    public class OrderForm {
        // 包含表單中的所有字段
    }

}


