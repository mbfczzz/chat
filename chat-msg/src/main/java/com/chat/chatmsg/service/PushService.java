package com.chat.chatmsg.service;

public interface PushService {
    void pushMsgToOne(String userId,String msg);

    void pushMsgToAll(String msg);
}
