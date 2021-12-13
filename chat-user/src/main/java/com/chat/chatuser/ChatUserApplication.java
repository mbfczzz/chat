package com.chat.chatuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan(basePackages = {"com.chat.chatuser.mapper"})
@SpringBootApplication(scanBasePackages = {"com.chat.chatcommon","com.chat.chatuser"})
@EnableDiscoveryClient
@EnableFeignClients
public class ChatUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChatUserApplication.class, args);
    }
}
