package com.dealdove.dealdove.model.dao;

import com.dealdove.dealdove.model.enitity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, String> {

    List<ChatMessage> findByChatId(String chatId);
}
