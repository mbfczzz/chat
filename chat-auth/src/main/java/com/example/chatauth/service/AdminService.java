package com.example.chatauth.service;

import com.chat.chatcommon.model.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user")
public interface AdminService {

    @GetMapping("/loadByUsername")
    UserDto loadUserByUsername(@RequestParam String username);
}
