package com.chat.chatuser.service;

import com.chat.chatcommon.api.CommonResult;
import com.chat.chatuser.Dto.UserModelDto;


public interface LoginServiceI {
    CommonResult Login(UserModelDto userDto);
}
