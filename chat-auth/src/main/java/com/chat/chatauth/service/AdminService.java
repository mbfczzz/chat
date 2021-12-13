package com.chat.chatauth.service;

import com.chat.chatcommon.model.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user")
public interface AdminService {

    @GetMapping("/user/loadByUsername")
    UserDto loadUserByUsername(@RequestParam String userName);
}
