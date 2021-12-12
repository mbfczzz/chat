package com.chat.chatmsg.service.impl;

import com.chat.chatmsg.service.NotifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;


@Service
@Slf4j
public class NotifyServiceImpl implements NotifyService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public <T> void SendEmail(List<Integer> id, Class<T> clazz) throws MessagingException {

    }
}
