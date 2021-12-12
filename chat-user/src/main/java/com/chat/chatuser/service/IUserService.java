package com.chat.chatuser.service;

import com.chat.chatcommon.model.UserDto;
import com.chat.chatuser.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mbfczzzz
 * @since 2021-12-12
 */
public interface IUserService extends IService<User> {
    public void addDefaultUser(User user);

    UserDto loadByUsername(String userName);
}
