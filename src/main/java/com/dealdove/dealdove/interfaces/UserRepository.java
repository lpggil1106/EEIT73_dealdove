package com.dealdove.dealdove.interfaces;

import com.dealdove.dealdove.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.io.Serializable;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT * FROM user", nativeQuery = true)
    List<User> findAllUsers();

    User save(User user);

    @Query(value = "SELECT email FROM user WHERE userID= :userID", nativeQuery = true)
    String findEmailById(@Param("userID") String userID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user SET gender = :gender WHERE userID = :userID", nativeQuery = true)
    void updateGender(@Param("gender") int gender, @Param("userID") String userID);

}