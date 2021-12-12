package com.chat.chatcommon.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class UserDto {
    private String userName;
    private String id;
    private String clientId;
    private String password;
    private List<String> authorities;
}
