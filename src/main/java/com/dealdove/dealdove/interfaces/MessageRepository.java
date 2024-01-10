package com.dealdove.dealdove.interfaces;

import com.dealdove.dealdove.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {

    @Query(value = "SELECT * FROM message WHERE senderID = 2 ", nativeQuery = true)
    List<Message> findMessage();

    @Query(value = "SELECT * FROM message",nativeQuery = true)
    List<Message> getAllMessage();

    @Query(value = "SELECT * FROM message where messageID = :id",nativeQuery = true)
    Message getMessageByID(@Param("id") Integer id);

    Message save(Message message);
}
