package com.chat.chatcommon.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class UserModel {
    //id
    private Integer id;
    //用户命
    private String  userName;
    //密码
    private String password;
    //手机号
    private String phone;
    private Date createTime;
    private Date updateTime;
    //邮箱
    private String email;
    //图像
    private String image;
    //是否可用
    private Byte isValid;
}
