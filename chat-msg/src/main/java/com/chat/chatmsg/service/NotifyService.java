package com.chat.chatmsg.service;

import javax.mail.MessagingException;
import java.util.List;

public interface NotifyService {
        <T> void SendEmail(List<Integer> id,Class<T> clazz) throws MessagingException;
}
