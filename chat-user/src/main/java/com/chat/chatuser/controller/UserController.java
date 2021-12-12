package com.chat.chatuser.controller;

import com.chat.chatcommon.model.UserDto;
import com.chat.chatuser.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/loadByUsername")
    public UserDto loadByUsername(String userName){
        return iUserService.loadByUsername(userName);
    }
}
