package com.jaruratcare.whatsappchatbot.controller;

import com.jaruratcare.whatsappchatbot.dto.ChatRequest;
import com.jaruratcare.whatsappchatbot.dto.ChatResponse;
import com.jaruratcare.whatsappchatbot.service.ChatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/webhook")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;
    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

    @PostMapping
    public ResponseEntity<ChatResponse> handleMessage(@Valid @RequestBody ChatRequest request) {

        logger.info("Incoming message received at {}: {}", LocalDateTime.now(), request.getMessage());

        ChatResponse reply = chatService.getReply(request.getMessage());

        logger.info("Reply sent: {}", reply.getReply());

        return ResponseEntity.ok(reply);
    }
}
