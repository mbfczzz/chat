package com.example.chatauth.service.impl;

import com.chat.chatcommon.exception.ParamException;
import com.chat.chatcommon.model.UserDto;
import com.example.chatauth.model.ActiveUser;
import com.example.chatauth.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * describe:用户认证
 *
 * @Author: mbfczzzz
 * @Date: 2021/12/11 16:41
 **/
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Autowired
    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String clientId = request.getParameter("client_id");
        UserDto userDto=null;
        if ("APP".equals(clientId)){
            userDto = adminService.loadUserByUsername(username);
        }
        else {
            throw new ParamException("不支持!");
        }
        userDto.setClientId(clientId);
        ActiveUser activeUser = new ActiveUser(userDto);
        return activeUser;
    }
}
