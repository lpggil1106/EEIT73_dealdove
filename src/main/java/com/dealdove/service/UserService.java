package com.dealdove.service;

import com.dealdove.interfaces.UserRepository;
import com.dealdove.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

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

    @Query(value = "select * from user")
    public User findAll(){
        return userRepository.findAll();
    }


}
