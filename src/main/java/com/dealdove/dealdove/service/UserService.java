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


}