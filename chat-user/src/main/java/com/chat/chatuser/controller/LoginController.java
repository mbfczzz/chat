package com.chat.chatuser.controller;

import com.chat.chatcommon.api.CommonResult;
import com.chat.chatuser.Dto.UserModelDto;
import com.chat.chatuser.service.LoginServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginServiceI loginServiceI;

    @RequestMapping("/login")
    public CommonResult login(@RequestBody UserModelDto userDto){
        return loginServiceI.Login(userDto);
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
