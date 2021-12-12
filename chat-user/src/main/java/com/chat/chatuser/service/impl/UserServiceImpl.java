package com.chat.chatuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chat.chatcommon.Utils.AssertsUtil;
import com.chat.chatcommon.model.UserDto;
import com.chat.chatuser.entity.User;
import com.chat.chatuser.mapper.UserMapper;
import com.chat.chatuser.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mbfczzzz
 * @since 2021-12-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void addDefaultUser(User user) {
        user.setUsername("Summoner");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        user.setValid(true);
        AssertsUtil.isTrue( 0 == userMapper.insert(user),"添加默认用户失败!");
    }

    @Override
    public UserDto loadByUsername(String userName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",userName);
        User user = userMapper.selectOne(queryWrapper);
        UserDto userDto = new UserDto();
        userDto.setUserName(userName);
        userDto.setId(user.getId().toString());
        userDto.setPassword(user.getPassword());
        List list = new ArrayList();
        list.add("chat");
        list.add("index");
        userDto.setAuthorities(list);
        return  userDto;
    }
}
