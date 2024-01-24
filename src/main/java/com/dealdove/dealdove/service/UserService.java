package com.dealdove.dealdove.service;

import com.dealdove.dealdove.interfaces.UserRepository;
import com.dealdove.dealdove.model.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZonedDateTime;
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

    public String findUserById(String userID){return userRepository.findEmailById(userID);}
    public Integer findGenderById(String userID){return userRepository.findGenderById(userID);}
    public LocalDate findBirthdayById(String userID){return userRepository.findBirthdayById(userID);}


    @Transactional
    public void update(int gender,String userID){
        userRepository.updateGender(gender,userID);
    }

    @Transactional
    public void updateBirthday(LocalDate birthday, String userID) {
        userRepository.updateBirthday(birthday, userID);
    }
}