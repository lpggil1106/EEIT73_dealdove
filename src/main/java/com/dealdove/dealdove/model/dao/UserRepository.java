package com.dealdove.dealdove.model.dao;

import com.dealdove.dealdove.model.enitity.Coupon;
import com.dealdove.dealdove.model.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT * FROM user", nativeQuery = true)
    List<User> findAllUsers();

    User save(User user);

    @Query(value = "SELECT  COUNT(email) FROM user WHERE email= :email", nativeQuery = true)
    String findAllByEmail(@Param("email") String email);
    @Query(value = "SELECT email FROM user WHERE userID= :userID", nativeQuery = true)
    String findEmailById(@Param("userID") String userID);
    @Query(value = "SELECT gender FROM  user WHERE userID= :userID",nativeQuery = true)
    Integer findGenderById(@Param("userID") String userID);

    @Query(value = "SELECT birthDate FROM  user WHERE userID= :userID", nativeQuery = true)
    LocalDate findBirthdayById(@Param("userID") String userID);

    @Query(value = "SELECT couponID FROM user WHERE userID= :userID",nativeQuery = true)
    List<Coupon> findCouponsByUserID(@Param("userID") String userID);
    @Query(value = "SELECT shippingAddress FROM user WHERE userID= :userID",nativeQuery = true)
    String findAddressByUserID(@Param("userID") String userID);


    User getUserNameByUserID(String userID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user SET gender = :gender WHERE userID = :userID", nativeQuery = true)
    void updateGender(@Param("gender") int gender, @Param("userID") String userID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user SET birthDate = :birthday WHERE userID = :userID", nativeQuery = true)
    void updateBirthday(@Param("birthday") LocalDate birthday, @Param("userID") String userID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user SET shippingAddress = :shippingAddress WHERE userID = :userID", nativeQuery = true)
    void updateshippingAddress(@Param("shippingAddress") String  shippingAddress, @Param("userID") String userID);

    List<User> findAllByStatus(boolean status);

}