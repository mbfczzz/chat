package com.chat.chatuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chat.chatcommon.Utils.AssertsUtil;
import com.chat.chatcommon.api.CommonResult;
import com.chat.chatcommon.constant.AuthConstant;
import com.chat.chatcommon.model.UserDto;
import com.chat.chatcommon.redisService.RedisOption;
import com.chat.chatuser.Dto.UserModelDto;
import com.chat.chatuser.entity.User;
import com.chat.chatuser.mapper.UserMapper;
import com.chat.chatuser.service.AuthService;
import com.chat.chatuser.service.IUserService;
import com.chat.chatuser.service.LoginServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

public class LoginServiceImpl implements LoginServiceI {

    @Autowired
    private RedisOption redisTemplate;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AuthService authService;
    @Autowired
    private IUserService iUserService;

    @Override
    public CommonResult Login(UserModelDto userDto) {
        //手机号登录
        if (AuthConstant.PHONE_LOGIN == userDto.getType()){
            return authService.getAccessToken(LoginPhone(userDto));
        }else if (AuthConstant.EMAIL_LOGIN == userDto.getType()){
            return authService.getAccessToken(LoginEmail(userDto));
        }
        return authService.getAccessToken(LoginUser(userDto));
    }

    private Map<String, String> LoginPhone(UserModelDto userDto){
        //判断验证码是否错误
        String code  = (String) redisTemplate.get("chat:login:phone:code");
        AssertsUtil.isTrue(code.equals(userDto.getCode()),"验证码错误!");
        //第一次注册,创建默认用户
        User userPhone = new User();
        userPhone.setPhone(userDto.getPhone());
        iUserService.addDefaultUser(userPhone);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone",userDto.getPhone());
        User user = userMapper.selectOne(queryWrapper);
        Map<String, String> params = new HashMap<>();
        params.put("client_id", "APP");
        params.put("client_secret","123456");
        params.put("grant_type","password");
        params.put("user",user.getUsername());
        params.put("password",user.getPassword());
        return params;
    }

    private Map<String, String> LoginEmail(UserModelDto userDto){
        //判断验证码是否错误
        String code  = (String) redisTemplate.get("chat:login:email:code");
        AssertsUtil.isTrue(code.equals(userDto.getCode()),"验证码错误!");
        //第一次注册,创建默认用户
        User userEmail = new User();
        userEmail.setEmail(userDto.getEmail());
        iUserService.addDefaultUser(userEmail);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email",userDto.getPhone());
        User user = userMapper.selectOne(queryWrapper);
        Map<String, String> params = new HashMap<>();
        params.put("client_id", "APP");
        params.put("client_secret","123456");
        params.put("type","123456");
        params.put("grant_type","password");
        params.put("user",user.getUsername());
        params.put("password",user.getPassword());
        return params;
    }

    private Map<String, String> LoginUser(UserModelDto userDto){
        Map<String, String> params = new HashMap<>();
        params.put("client_id", "APP");
        params.put("client_secret","123456");
        params.put("type","123456");
        params.put("grant_type","password");
        params.put("user",userDto.getUserName());
        params.put("password",userDto.getPassword());
        return params;
    }
}
