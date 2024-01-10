package com.dealdove.dealdove.service;

import com.dealdove.dealdove.interfaces.MessageRepository;
import com.dealdove.dealdove.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class MessageService{

    @Autowired
    MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> findMessage(){
        return messageRepository.findMessage();
    }
    public ZonedDateTime setTaipeiTimezone(ZonedDateTime time){
        return time.plusHours(8);
    }
}
