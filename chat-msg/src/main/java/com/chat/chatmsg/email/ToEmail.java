package com.chat.chatmsg.email;

import com.chat.chatmsg.model.Email;

import javax.mail.MessagingException;

public  interface  ToEmail {

    void sendEmail(Email email) throws MessagingException;
}
