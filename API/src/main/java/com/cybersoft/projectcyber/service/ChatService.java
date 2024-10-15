package com.cybersoft.projectcyber.service;

import com.cybersoft.projectcyber.entity.Message;
import com.cybersoft.projectcyber.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChatService {
    @Autowired
    MessageRepository messageRepository;

    public Message saveMessage(Message message) {
        message.setTimestamp(System.currentTimeMillis());
        return messageRepository.save(message);
    }
}
