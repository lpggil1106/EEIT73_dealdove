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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CouponRepository couponRepository;
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

        LocalDate birthday = (user.get("birthday").isEmpty()) ? userRepository.findBirthdayById(userID) : LocalDate.parse(user.get("birthday"));
        userRepository.updateBirthday(birthday, userID);
    }

    public List<HashMap<String, String>> showInfo(LinkedHashMap<String, String> user) {
        FirebaseToken decodedToken = getFirebaseToken(user.get("idToken"));
        String userID = decodedToken.getUid();
        String email = userRepository.findEmailById(userID);
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