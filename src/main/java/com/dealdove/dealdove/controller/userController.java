package com.dealdove.dealdove.controller;


import com.dealdove.dealdove.service.MessageService;
import com.dealdove.dealdove.service.UserService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

@RestController
public class userController {

    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;

    //    取得FirebaseToken method
    public FirebaseToken getFirebaseToken(String request) {
        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(request);
            return decodedToken;
        } catch (FirebaseAuthException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/Users")
    public String user(@RequestBody  LinkedHashMap<String, String> request) {
        FirebaseToken decodedToken = getFirebaseToken(request.get("idToken"));
        String email = decodedToken.getEmail();
        String uid = decodedToken.getUid();
        String name = (decodedToken.getName() == null) ? decodedToken.getEmail() : decodedToken.getName();

        if (userService.findUserById(uid)!=null){
            System.out.println("User : "+uid+" login");
        } else if (userService.findUserById(uid)==null) {
            System.out.println("User : "+uid+" Register");
            userService.save(uid, name, email, true);
        }
        System.out.println(email+uid+name);
        return "{\"idToken:\":\""+request.get("idToken")+"\"}";

    }


//    顯示使用者資訊
    @PostMapping("/showInfo")
    public @ResponseBody String member(@RequestBody  LinkedHashMap<String, String> idToken) {
        FirebaseToken decodedToken = getFirebaseToken(idToken.get("idToken"));
        String uid = decodedToken.getUid();
        String email = userService.findUserById(uid);
        Integer gender = userService.findGenderById(uid);
        LocalDate birthday = userService.findBirthdayById(uid);
        return "{\"email\":\"" + email + "\",\"gender\":\""+gender+"\",\"birthday\":\""+birthday+"\"}";
    }

//    設定使用者資訊
    @PostMapping("/setInfo")
    public @ResponseBody int gender(@RequestBody LinkedHashMap<String, String> user){
        FirebaseToken decodedToken = getFirebaseToken(user.get("idToken"));
        Integer gender =(user.get("gender")==null)?0:Integer.parseInt(user.get("gender"));
        String uid = decodedToken.getUid();







        LocalDate birthday = LocalDate.parse(user.get("birthday"));
        String address = user.get("address");
        System.out.println(address);

        userService.update(gender,uid);
        userService.updateBirthday(birthday,uid);
        return gender;
    }



}

//    @RequestMapping("/time")
//    public List<Message> test3() {
//        Message message = messageService.getMessageByID(3, 1);
//        System.out.println(messageService.getAllMessage() + "123");
//        System.out.println(message.getText());
//        messageService.saveMessage(1, 2, "Saveddefault");
//        return messageService.findMessage();
//    }
