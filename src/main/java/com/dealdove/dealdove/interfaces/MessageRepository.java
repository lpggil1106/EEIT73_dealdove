package com.dealdove.dealdove.interfaces;

import com.dealdove.dealdove.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {

    @Query(value = "SELECT * FROM Message WHERE senderID = 2 ", nativeQuery = true)
    List<Message> findMessage();
}
