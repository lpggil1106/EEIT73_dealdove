package com.dealdove.service;

import com.dealdove.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void findByUsername(String username) {
        userRepository.findByUsername(username);
    }

    public List findAllUsers() {
        return userRepository.findAllUsers();
    }


}
