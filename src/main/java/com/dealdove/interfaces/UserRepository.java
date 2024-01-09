package com.dealdove.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface UserRepository<User,Integer extends Serializable> extends JpaRepository<User, Integer> {
    List<User> findByUsername(@Param("userID")String userID);
}
