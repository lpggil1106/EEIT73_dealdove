package com.dealdove.dealdove.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface UserRepository<User,Integer extends Serializable> extends JpaRepository<User, Integer> {
    List<User> findByUsername(@Param("userID")String userID);

    @Query(value = "select * from user",nativeQuery = true)
    List<User> findAllUsers();
}
