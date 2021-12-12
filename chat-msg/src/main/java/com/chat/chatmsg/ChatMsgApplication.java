package com.chat.chatmsg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.chat.chat-common","com.chat.chat-msg"})
@MapperScan(basePackages = "com.chat.chatmsg.mapper")
public class ChatMsgApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChatMsgApplication.class, args);
    }
}
