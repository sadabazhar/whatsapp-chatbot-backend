package com.jaruratcare.whatsappchatbot.service;

import com.jaruratcare.whatsappchatbot.dto.ChatResponse;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ChatService {

    public ChatResponse getReply(String message) {

        // Edge case
        if (message == null || message.trim().isEmpty()) {
            return ChatResponse.builder()
                    .reply("Message cannot be empty")
                    .time(LocalDateTime.now())
                    .build();
        }

        return switch (message.toLowerCase()) {
            case "hi" -> ChatResponse.builder()
                    .reply("Hello")
                    .time(LocalDateTime.now())
                    .build();
            case "bye" -> ChatResponse.builder()
                    .reply("Goodbye")
                    .time(LocalDateTime.now())
                    .build();
            default -> ChatResponse.builder()
                    .reply("I don't understand")
                    .time(LocalDateTime.now())
                    .build();
        };
    }
}