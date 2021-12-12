package com.chat.chatuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.chat.chat-common","com.chat.chat-user"})
@MapperScan(basePackages = "com.chat.chatuser.mapper")
public class ChatUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChatUserApplication.class, args);
    }
}
