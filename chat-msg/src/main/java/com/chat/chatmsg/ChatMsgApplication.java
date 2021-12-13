package com.chat.chatmsg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"com.chat.chatcommon","com.chat.chatmsg"})
@MapperScan(basePackages = "com.chat.chatmsg.mapper")
@EnableDiscoveryClient
public class ChatMsgApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChatMsgApplication.class, args);
    }
}
