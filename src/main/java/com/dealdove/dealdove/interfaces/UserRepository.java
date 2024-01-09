package com.dealdove.dealdove.interfaces;

import com.dealdove.dealdove.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT userID, userName,avatar FROM user", nativeQuery = true)
    List<User> findAllUsers();
}