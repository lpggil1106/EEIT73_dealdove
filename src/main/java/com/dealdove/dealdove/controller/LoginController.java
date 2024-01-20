package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.IdToken;
import com.dealdove.dealdove.model.MyRequest;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
public class LoginController {

    @PostMapping( "/login3")
    public @ResponseBody String login(@RequestBody IdToken idToken){
        System.out.println(idToken.getIdToken());
        System.out.println("breakpoint");


        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken.getIdToken());
            String email = decodedToken.getEmail();
            String uid = decodedToken.getUid();
            String name = decodedToken.getName();
            System.out.println("breakpoint");
            System.out.println(email);
            System.out.println(uid);
            System.out.println(name);
            return idToken.getIdToken();
        } catch (FirebaseAuthException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }


//    帳號註冊驗證
    @PostMapping("/verify")
    public int emailVerify(@RequestBody MyRequest user){
        String email = user.getEmail();
        String emailPattern = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
        Pattern emailRegex = Pattern.compile(emailPattern);
        Matcher emailMatcher = emailRegex.matcher(email);

        String password = user.getPassword();
        String passwordPattern ="^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        Pattern passwordRegex = Pattern.compile(passwordPattern);
        Matcher passwordMatcher = passwordRegex.matcher(password);

        if(!emailMatcher.matches()){
            return 10;
        }
        if(!passwordMatcher.matches()){
            return 20;
        }
        return 1;
    }


}
