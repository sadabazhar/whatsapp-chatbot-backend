package com.jaruratcare.whatsappchatbot.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class ChatResponse {

    private String reply;
    private LocalDateTime time;
}
