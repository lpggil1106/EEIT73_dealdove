package com.dealdove.dealdove.service;

import com.dealdove.dealdove.dao.UserRepository;
import com.dealdove.dealdove.model.Order;
import com.dealdove.dealdove.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
    public void login(LinkedHashMap<String, String> users){
        FirebaseToken decodedToken = getFirebaseToken(users.get("idToken"));
        String userID = decodedToken.getUid();
        String email = decodedToken.getEmail();
        String name = (decodedToken.getName()==null)? decodedToken.getEmail() : decodedToken.getName();
        System.out.println(decodedToken.getPicture());
        if(userRepository.findEmailById(userID)!=null){
            System.out.println("User : "+userID+" Login!");
        }else if(userRepository.findEmailById(userID)==null){
            System.out.println("User : "+userID+" register!");
            User user = new User();
            user.setUserID(userID);
            user.setUserName(name);
            user.setEmail(email);
            user.setStatus(true);
            userRepository.save(user);
        }
    }

    @Transactional
    public void updateUser(LinkedHashMap<String, String> user){
        FirebaseToken decodedToken = getFirebaseToken(user.get("idToken"));
        String userID = decodedToken.getUid();
        int gender =(user.get("gender")==null)?0:Integer.parseInt(user.get("gender"));
        userRepository.updateGender(gender,userID);

        LocalDate birthday =(user.get("birthday").isEmpty())?userRepository.findBirthdayById(userID):LocalDate.parse(user.get("birthday"));
        userRepository.updateBirthday(birthday,userID);
    }

    public Object[] showInfo(LinkedHashMap<String, String> user){
        FirebaseToken decodedToken = getFirebaseToken(user.get("idToken"));
        String userID = decodedToken.getUid();
        String picture = decodedToken.getPicture();
        String email = userRepository.findEmailById(userID);
        int gender = userRepository.findGenderById(userID);
        LocalDate birthday = userRepository.findBirthdayById(userID);

        return new Object[]{email,gender,birthday,picture};
    }

    public List<Order> findOrderByUserID(LinkedHashMap<String, String> user){
        FirebaseToken decodedToken = getFirebaseToken(user.get("idToken"));
        String userID = decodedToken.getUid();
        List<Order> orders =  userRepository.findOrderByUserID(userID);
        for(Order order : orders){
            System.out.println(order.getOrderItems());
        }
        return orders;
    }

//    public List<User> findAllUsers() {
//        return userRepository.findAllUsers();
//    }
//
//
//
//    public String findUserById(String userID){return userRepository.findEmailById(userID);}
//    public Integer findGenderById(String userID){return userRepository.findGenderById(userID);}
//    public LocalDate findBirthdayById(String userID){return userRepository.findBirthdayById(userID);}

//    public void saveUser(User user) {
//        user.setStatus(true);
//        userRepository.save(user);
//    }
//
//    public void disconnect(User user) {
//        var storedUser = userRepository.findById(user.getUserID()).orElse(null);
//        if (storedUser != null) {
//            storedUser.setStatus(false);
//            userRepository.save(storedUser);
//        }
//    }
//
//    public List<User> findConnectedUsers() {
//        return userRepository.findAllByStatus(true);
//    }

}