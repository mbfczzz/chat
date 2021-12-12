package com.chat.chatuser.controller;

import com.chat.chatcommon.api.CommonResult;
import com.chat.chatuser.Dto.UserModelDto;
import com.chat.chatuser.service.LoginServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginServiceI loginServiceI;

    public CommonResult login(UserModelDto userDto){
        return loginServiceI.Login(userDto);
    }
}
