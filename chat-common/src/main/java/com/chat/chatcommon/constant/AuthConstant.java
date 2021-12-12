package com.chat.chatcommon.constant;

public interface AuthConstant {

    /**
     * JWT存储权限前缀
     */
    String AUTHORITY_PREFIX = "ROLE_";

    /**
     * JWT存储权限属性
     */
    String AUTHORITY_CLAIM_NAME = "authorities";

    /**
     * 认证信息Http请求头
     */
    String JWT_TOKEN_HEADER = "Authorization";

    /**
     * JWT令牌前缀
     */
    String JWT_TOKEN_PREFIX = "Bearer ";

    /**
     * 用户信息Http请求头
     */
    String USER_TOKEN_HEADER = "user";

    /**
     * 邮箱登录
     */
    Integer EMAIL_LOGIN = 2;

    /**
     * 手机号登录
     */
    Integer PHONE_LOGIN = 1;

    /**
     * 用户名密码登录
     */
    Integer USER_LOGIN = 0;
}

