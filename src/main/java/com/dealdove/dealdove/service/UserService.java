package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.dao.CouponRepository;
import com.dealdove.dealdove.model.dao.UserRepository;
import com.dealdove.dealdove.model.enitity.Coupon;
import com.dealdove.dealdove.model.enitity.CouponBase;
import com.dealdove.dealdove.model.enitity.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CouponRepository couponRepository;

    private  String shopInfo;
    @Autowired
    public UserService(UserRepository userRepository, CouponRepository couponRepository) {
        this.userRepository = userRepository;
        this.couponRepository = couponRepository;
    }
    //    Firebase 解析器
    public FirebaseToken getFirebaseToken(String userToken) {
        try {
            return FirebaseAuth.getInstance().verifyIdToken(userToken);
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }
    }


    //    會員登入
    public void login(LinkedHashMap<String, String> users) {
        FirebaseToken decodedToken = getFirebaseToken(users.get("idToken"));
        String userID = decodedToken.getUid();
        String email = decodedToken.getEmail();
        String name = (decodedToken.getName() == null) ? decodedToken.getEmail() : decodedToken.getName();
        String avatar = (decodedToken.getPicture() == null) ? "https://img.tukuppt.com/png_preview/00/09/56/g3nYjpNuGM.jpg!/fw/780" : decodedToken.getPicture();
        System.out.println(avatar);
        if (userRepository.findEmailById(userID) != null) {
            System.out.println("User : " + userID + " Login!");
        } else if (userRepository.findEmailById(userID) == null) {
            System.out.println("User : " + userID + " register!");
            User user = new User();
            user.setUserID(userID);
            user.setUserName(name);
            user.setEmail(email);
            user.setStatus(true);
            user.setAvatar(avatar);
            userRepository.save(user);
        }
    }

    @Transactional
    public void updateUser(LinkedHashMap<String, String> user) {
        FirebaseToken decodedToken = getFirebaseToken(user.get("idToken"));
        String userID = decodedToken.getUid();
        int gender = (user.get("gender") == null) ? 0 : Integer.parseInt(user.get("gender"));
        userRepository.updateGender(gender, userID);
        userRepository.updateshippingAddress(shopInfo,userID);
        LocalDate birthday = (user.get("birthday").isEmpty()) ? userRepository.findBirthdayById(userID) : LocalDate.parse(user.get("birthday"));
        userRepository.updateBirthday(birthday, userID);
    }

    public List<HashMap<String, String>> showInfo(LinkedHashMap<String, String> user) {
        FirebaseToken decodedToken = getFirebaseToken(user.get("idToken"));
        String userID = decodedToken.getUid();
        String email = userRepository.findEmailById(userID);
        String address = (userRepository.findAddressByUserID(userID)==null)?"請選擇門市後按確定鍵":userRepository.findAddressByUserID(userID);
        int gender = userRepository.findGenderById(userID);
        LocalDate birthday = userRepository.findBirthdayById(userID);
        if (birthday == null) {
            birthday = LocalDate.now();
        }

        List<HashMap<String, String>> userInfoList = new ArrayList<>();
        HashMap<String, String> userInfoMap = new HashMap<>();
        userInfoMap.put("email", email);
        userInfoMap.put("gender", Integer.toString(gender));
        userInfoMap.put("birthday", birthday.toString());
        userInfoMap.put("address", address);
        userInfoList.add(userInfoMap);
        return userInfoList;
    }

    public List<String> showCoupon(LinkedHashMap<String, String> user){
        FirebaseToken decodedToken = getFirebaseToken(user.get("idToken"));
        String userID = decodedToken.getUid();
        List<Coupon> coupons =  couponRepository.findCouponByUserID(userID);
            List<String> Desc = new ArrayList<>();
        for(Coupon coupon : coupons){
            CouponBase couponBases = coupon.getCouponBase();
            System.out.println(couponBases.getCouponDescription());
            Desc.add(couponBases.getCouponDescription());
        }
            return Desc;

    }

    public int findUserByEmail(String email){
       String count = userRepository.findAllByEmail(email);
        return Integer.parseInt(count);
    }

    public HashMap<String,String> decoded(String code){
    HashMap<String,String> shopMap = new HashMap<>();
        try{
            String decodedCode = URLDecoder.decode(code, StandardCharsets.UTF_8);
            String[] keyValuePairs = decodedCode.split("&");
            for (String pair : keyValuePairs) {
                String[] entry = pair.split("=");
                if (entry.length >= 2) {
                    shopMap.put(entry[0], entry[1]);
                }
            }
           shopInfo =  "寄送店名:"+shopMap.get("storename")+"地址:"+shopMap.get("storeaddress");
        }catch (Exception e){
            System.out.println(e);
        }
        return shopMap;
    }





//-----------------------------------------------------------
    public void saveUser(User user) {
        user.setStatus(true);
        userRepository.save(user);
    }

    public void disconnect(User user) {
        var storedUser = userRepository.findById(user.getUserID()).orElse(null);
        if (storedUser != null) {
            storedUser.setStatus(false);
            userRepository.save(storedUser);
        }
    }

    public List<User> findConnectedUsers() {
        return userRepository.findAllByStatus(true);
    }

}