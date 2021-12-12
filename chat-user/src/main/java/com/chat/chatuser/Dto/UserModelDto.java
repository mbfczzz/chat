package com.chat.chatuser.Dto;

import com.chat.chatcommon.pojo.UserModel;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserModelDto extends UserModel {
    //登录类型
    private Integer type;
    //验证码
    private String code;
}
