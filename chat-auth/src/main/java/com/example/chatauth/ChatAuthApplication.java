package com.example.chatauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.chat.chat-common","com.chat.chat-auth"})
public class ChatAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatAuthApplication.class, args);
    }

}
