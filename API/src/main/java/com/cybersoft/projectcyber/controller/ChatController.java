package com.cybersoft.projectcyber.controller;

import com.cybersoft.projectcyber.entity.Message;
import com.cybersoft.projectcyber.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
public class ChatController {
    @Autowired
    ChatService chatService;

    @MessageMapping("/chat")  // Đường dẫn client sẽ gửi tin nhắn
    @SendTo("/topic/messages") // Tin nhắn sẽ được phát đến các user đã đăng ký
    public Message sendMessage(Message message) {
        Message savedMessage  = chatService.saveMessage(message);
        return savedMessage;
    }
}
