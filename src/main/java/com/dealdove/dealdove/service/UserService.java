package com.dealdove.dealdove.service;

import com.dealdove.dealdove.interfaces.UserRepository;
import com.dealdove.dealdove.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public void save(String userID,String username,String email,boolean status){
        User user = new User();
        user.setUserID(userID);
        user.setUserName(username);
        user.setEmail(email);
        System.out.println("testService");
        user.setStatus(status);
        userRepository.save(user);
    }

}