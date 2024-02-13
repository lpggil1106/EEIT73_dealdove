package com.dealdove.dealdove.service;

import com.dealdove.dealdove.model.dao.MessageRepository;
import com.dealdove.dealdove.model.enitity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> findMessage() {
        return messageRepository.findMessage();
    }

    public List<Message> getAllMessage() {
        return messageRepository.getAllMessage();
    }

    public Message getMessageByID(Integer senderid ,Integer receiverid){
        return messageRepository.getMessageByID(senderid,receiverid);
    }

    public void saveMessage(Integer senderID,Integer receiverID,String text){
         Message message = new Message();
         message.setSenderId(senderID);
         message.setReceiverId(receiverID);
         message.setText(text);


        messageRepository.save(message);
    }

}
