package com.dealdove.dealdove.dao;

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

    @Query(value = "SELECT * FROM message where receiverID = :receiverid AND senderID= :senderID",nativeQuery = true)
    Message getMessageByID(@Param("receiverid") Integer receiverid,@Param("senderID")Integer senderid);


    //Insert a new row
    Message save(Message message);
}
